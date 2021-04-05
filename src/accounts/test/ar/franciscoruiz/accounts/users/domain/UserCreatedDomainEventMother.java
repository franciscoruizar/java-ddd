package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.users.UserCreatedDomainEvent;

public final class UserCreatedDomainEventMother {
    public static UserCreatedDomainEvent create(UserId id, UserName name, UserLastname lastname, UserUsername username, UserEmail email) {
        return new UserCreatedDomainEvent(id.value(), name.value(), lastname.value(), username.value(), email.value());
    }

    public static UserCreatedDomainEvent create(User user) {
        return new UserCreatedDomainEvent(user.id().value(), user.name().value(), user.lastname().value(), user.username().value(), user.email().value());
    }

    public static UserCreatedDomainEvent random() {
        return UserCreatedDomainEventMother.create(UserMother.random());
    }
}
