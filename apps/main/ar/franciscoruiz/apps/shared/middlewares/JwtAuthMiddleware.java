package ar.franciscoruiz.apps.shared.middlewares;

import ar.franciscoruiz.accounts.authorizations.application.AuthorizationsResponse;
import ar.franciscoruiz.accounts.authorizations.application.search_by_role.SearchAuthorizationsByRoleIdQuery;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find_by_username.FindUserByUsernameQuery;
import ar.franciscoruiz.accounts.users.domain.UserNotExist;
import ar.franciscoruiz.apps.shared.utils.JwtUtil;
import ar.franciscoruiz.shared.domain.applications.Application;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

public final class JwtAuthMiddleware implements Filter {
    private final JwtUtil  jwtUtil;
    private final QueryBus bus;

    public JwtAuthMiddleware(JwtUtil jwtUtil, QueryBus bus) {
        this.jwtUtil = jwtUtil;
        this.bus     = bus;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorizationHeader = ((HttpServletRequest) request).getHeader("Authorization");

        if (hasIntroducedJwt(authorizationHeader)) {
            authenticate(authorizationHeader, chain, request, response);
        } else {
            setInvalidToken(response);
        }
    }

    private void authenticate(
        String authorizationHeader,
        FilterChain chain,
        ServletRequest request,
        ServletResponse response
    ) throws IOException, ServletException {
        String token    = authorizationHeader.substring(7);
        String username = jwtUtil.extractUsername(token);

        if (username == null || !ensureApplication(token)) {
            setInvalidToken(response);
        } else {
            try {
                authorize(chain, request, response, token, username);
            } catch (UserNotExist ignored) {
                setInvalidToken(response);
            }
        }
    }

    private boolean ensureApplication(String token) {
        String applicationValue = jwtUtil.extractApplication(token);

        if (applicationValue == null)
            return false;

        return Application.findByValue(applicationValue).isPresent();
    }

    private void authorize(
        FilterChain chain,
        ServletRequest request,
        ServletResponse response,
        String token,
        String username
    ) throws IOException, ServletException {
        UserResponse user = bus.ask(new FindUserByUsernameQuery(username));

        if (jwtUtil.validate(token, user) && isAuthorization(request, user.roleId())) {
            request.setAttribute("authentication_id", user.id());
            request.setAttribute("authentication_username", user.username());
            request.setAttribute("authentication_role", user.roleId());

            chain.doFilter(request, response);
        } else {
            setInvalidToken(response);
        }
    }

    private String uri(ServletRequest request) {
        return parseUri(((HttpServletRequest) request).getRequestURI());
    }

    private String methodHttp(ServletRequest request) {
        return ((HttpServletRequest) request).getMethod();
    }

    private boolean hasIntroducedJwt(String authorizationHeader) {
        return null != authorizationHeader && authorizationHeader.startsWith("Bearer");
    }

    private boolean isAuthorization(ServletRequest request, String roleId) {
        String uri    = uri(request);
        String method = methodHttp(request);
        String module = uri.replace("/api", "").replace("/", "");

        AuthorizationsResponse responses = bus.ask(new SearchAuthorizationsByRoleIdQuery(roleId));

        return responses.values().stream().anyMatch(response ->
            response.methods().contains(method) && response.module().equals(module)
        );
    }

    private void setInvalidToken(ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.reset();
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private String parseUri(String uri) {
        var partsUri = Arrays.stream(uri.split("/"))
            .map(s -> isUUID(s) ? "{id}" : s)
            .collect(Collectors.toList());

        return String.join("/", partsUri);
    }

    private boolean isUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException ignored) {
            return false;
        }
    }
}
