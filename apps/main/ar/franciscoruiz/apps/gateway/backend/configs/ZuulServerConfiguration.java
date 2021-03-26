package ar.franciscoruiz.apps.gateway.backend.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;

@Configuration
public class ZuulServerConfiguration {

    @Bean(name = "zuul.CONFIGURATION_PROPERTIES")
    @Primary
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        ZuulProperties properties = new ZuulProperties();

        properties.setRoutes(new HashMap<>() {{
            put("accounts_backend", new ZuulProperties.ZuulRoute("/api/accounts/**"));
        }});



        return properties;
    }

}
