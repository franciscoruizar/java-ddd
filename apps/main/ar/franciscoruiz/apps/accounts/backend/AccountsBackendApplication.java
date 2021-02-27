package ar.franciscoruiz.apps.accounts.backend;

import ar.franciscoruiz.shared.domain.Service;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {
        "ar.franciscoruiz.shared",
        "ar.franciscoruiz.accounts",
        "ar.franciscoruiz.apps.shared",
        "ar.franciscoruiz.apps.accounts.backend"
    }
)
public class AccountsBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {
        };
    }
}
