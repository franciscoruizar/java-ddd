package ar.franciscoruiz.apps.retentions;

import ar.franciscoruiz.apps.retentions.commands.ConsumeMySqlDomainEventsCommand;
import ar.franciscoruiz.apps.retentions.commands.ConsumeRabbitMqDomainEventsCommand;
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
        "ar.franciscoruiz.retentions",
        "ar.franciscoruiz.apps.shared",
        "ar.franciscoruiz.apps.retentions"
    }
)
public class RetentionsApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<>() {{
            put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
            put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
        }};
    }
}
