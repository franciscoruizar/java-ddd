package ar.franciscoruiz.apps.accounts.backend.configs;

import ar.franciscoruiz.apps.shared.middlewares.JwtAuthMiddleware;
import ar.franciscoruiz.apps.shared.utils.JwtUtil;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountsBackendSecurityConfiguration {
    private final JwtUtil  jwtUtil;
    private final QueryBus bus;

    public AccountsBackendSecurityConfiguration(JwtUtil jwtUtil, QueryBus bus) {
        this.jwtUtil = jwtUtil;
        this.bus     = bus;
    }

    @Bean
    public FilterRegistrationBean<JwtAuthMiddleware> jwtAuthMiddleware() {
        FilterRegistrationBean<JwtAuthMiddleware> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtAuthMiddleware(jwtUtil, bus));
        registrationBean.addUrlPatterns("/api/actions", "/api/modules", "/api/actions", "/api/roles/*", "/api/users");
        return registrationBean;
    }
}
