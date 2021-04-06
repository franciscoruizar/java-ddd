package ar.franciscoruiz.apps.retentions.commands;

import ar.franciscoruiz.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import ar.franciscoruiz.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeRabbitMqDomainEventsCommand extends ConsoleCommand {
    private final RabbitMqDomainEventsConsumer consumer;

    public ConsumeRabbitMqDomainEventsCommand(RabbitMqDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}
