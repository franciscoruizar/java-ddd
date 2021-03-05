package ar.franciscoruiz.apps.shared.middlewares;

import ar.franciscoruiz.apps.shared.utils.JwtUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public final class JwtAuthMiddleware implements Filter {
    private final JwtUtil jwtUtil;

    public JwtAuthMiddleware(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
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
        String token  = authorizationHeader.substring(7);
        Map    claims = jwtUtil.claims(token);

        if (validate(token, claims)) {
            setInvalidToken(response);
        } else {
            request.setAttribute("authentication_id", claims.get("id"));
            request.setAttribute("authentication_username", claims.get("username"));
            request.setAttribute("authentication_role", claims.get("role"));

            chain.doFilter(request, response);
        }
    }

    private boolean validate(String token, Map claims) {
        return token.equals("") || jwtUtil.isTokenExpired(token) || claims == null || !(Boolean) claims.get("is_active");
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
