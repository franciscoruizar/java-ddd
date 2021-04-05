package ar.franciscoruiz.shared.domain.users;

import ar.franciscoruiz.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class UserCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String lastname;
    private final String username;
    private final String email;

    public UserCreatedDomainEvent(
        String aggregateId,
        String name,
        String lastname,
        String username,
        String email
    ) {
        super(aggregateId);
        this.name     = name;
        this.lastname = lastname;
        this.username = username;
        this.email    = email;
    }

    public UserCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String name,
        String lastname,
        String username,
        String email
    ) {
        super(aggregateId, eventId, occurredOn);
        this.name     = name;
        this.lastname = lastname;
        this.username = username;
        this.email    = email;
    }

    public UserCreatedDomainEvent(String aggregateId) {
        super(aggregateId);

        this.name     = null;
        this.lastname = null;
        this.username = null;
        this.email    = null;
    }

    public UserCreatedDomainEvent() {
        this.name     = null;
        this.lastname = null;
        this.username = null;
        this.email    = null;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<>() {{
            put("name", name);
            put("lastname", lastname);
            put("username", username);
            put("email", email);
        }};
    }

    @Override
    public DomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new UserCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("lastname"),
            (String) body.get("username"),
            (String) body.get("email")
        );
    }

    public String name() {
        return name;
    }

    public String lastname() {
        return lastname;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreatedDomainEvent that = (UserCreatedDomainEvent) o;
        return Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname) && Objects.equals(username, that.username) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname, username, email);
    }
}
