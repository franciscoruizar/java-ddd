package ar.franciscoruiz.shared.infrastructure.bus.event.mysql;

import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateConfigurationFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class DomainEventsHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "domain_events";

    public DomainEventsHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("domain_events-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("domain_events-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("domain_events-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("DOMAIN-EVENTS_DATABASE_HOST"),
            config.getInt("DOMAIN-EVENTS_DATABASE_PORT"),
            config.get("DOMAIN-EVENTS_DATABASE_NAME"),
            config.get("DOMAIN-EVENTS_DATABASE_USER"),
            config.get("DOMAIN-EVENTS_DATABASE_PASSWORD")
        );
    }
}
