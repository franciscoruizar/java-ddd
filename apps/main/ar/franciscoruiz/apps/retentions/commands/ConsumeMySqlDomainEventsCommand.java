package ar.franciscoruiz.apps.retentions.commands;

import ar.franciscoruiz.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import ar.franciscoruiz.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {
    private final MySqlDomainEventsConsumer consumer;

    public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}
