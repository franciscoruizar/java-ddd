package ar.franciscoruiz.retentions.mails.application;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.event.DomainEventSubscriber;
import ar.franciscoruiz.shared.domain.users.UserCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber({UserCreatedDomainEvent.class})
public final class SendUserWelcomeEmailOnUserCreated {
    private final UserCreatedEmailSender sender;

    public SendUserWelcomeEmailOnUserCreated(UserCreatedEmailSender sender) {
        this.sender = sender;
    }

    @EventListener
    public void on(UserCreatedDomainEvent event) {
        sender.send(event.email(), event.username(), event.name(), event.lastname());
    }
}
