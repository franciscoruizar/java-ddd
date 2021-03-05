package ar.franciscoruiz.apps.accounts.backend.configs;

import ar.franciscoruiz.apps.shared.middlewares.JwtAuthMiddleware;
import ar.franciscoruiz.apps.shared.utils.JwtUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsBackendSecurityConfiguration {
    private final JwtUtil jwtUtil;

    public AccountsBackendSecurityConfiguration(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public FilterRegistrationBean<JwtAuthMiddleware> jwtAuthMiddleware() {
        FilterRegistrationBean<JwtAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtAuthMiddleware(jwtUtil));
        registrationBean.addUrlPatterns("/api/actions", "/api/modules", "/api/actions", "/api/roles/actions", "/api/users", "/api/roles");

        return registrationBean;
    }
}
