package ar.franciscoruiz.cms.shared.infrastructure.persistence;

import ar.franciscoruiz.shared.infrastructure.bus.event.DomainEventsInformation;
import ar.franciscoruiz.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import ar.franciscoruiz.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import ar.franciscoruiz.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CmsMySqlEventBusConfiguration {
    private final SessionFactory            sessionFactory;
    private final DomainEventsInformation   domainEventsInformation;
    private final SpringApplicationEventBus bus;

    public CmsMySqlEventBusConfiguration(
        @Qualifier("domain_events-session_factory") SessionFactory sessionFactory,
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus
    ) {
        this.sessionFactory          = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.bus                     = bus;
    }

    @Bean
    public MySqlEventBus moocMysqlEventBus() {
        return new MySqlEventBus(sessionFactory);
    }

    @Bean
    public MySqlDomainEventsConsumer moocMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
    }
}
