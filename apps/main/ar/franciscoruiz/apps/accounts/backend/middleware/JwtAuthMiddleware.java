package ar.franciscoruiz.apps.accounts.backend.middleware;

import ar.franciscoruiz.accounts.auth.application.find_by_username.FindAuthUserByUsernameQuery;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthCredentials;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthUsername;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.JwtUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String jwt      = authorizationHeader.substring(7);
        String username = jwtUtil.extractUsername(jwt).value();

        if (username == null) {
            setInvalidToken(response);
        }

        try {
            AuthUser user = bus.ask(new FindAuthUserByUsernameQuery(username));

            request.setAttribute("authentication_username", user);

            if (jwtUtil.validateToken(jwt, user)) {
                chain.doFilter(request, response);
            }
        } catch (InvalidAuthUsername | InvalidAuthCredentials | CommandHandlerExecutionError error) {
            setInvalidToken(response);
        }
    }

    private boolean hasIntroducedJwt(String authorizationHeader) {
        return null != authorizationHeader && authorizationHeader.startsWith("Bearer");
    }

    private void setInvalidToken(ServletResponse response) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.reset();
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
