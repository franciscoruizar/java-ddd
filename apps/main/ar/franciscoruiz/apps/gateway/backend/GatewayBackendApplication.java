package ar.franciscoruiz.apps.gateway.backend;

import ar.franciscoruiz.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {
        "ar.franciscoruiz.shared",
        "ar.franciscoruiz.apps.shared",
        "ar.franciscoruiz.apps.gateway.backend"
    }
)
@EnableZuulProxy
public class GatewayBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {
        };
    }
}
