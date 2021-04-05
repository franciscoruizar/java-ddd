package ar.franciscoruiz.accounts.users.application.registration;

import ar.franciscoruiz.accounts.users.UsersModuleUnitTestCase;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserCreatedDomainEventMother;
import ar.franciscoruiz.accounts.users.domain.UserExists;
import ar.franciscoruiz.accounts.users.domain.UserMother;
import ar.franciscoruiz.shared.domain.users.UserCreatedDomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class UserRegisterShould extends UsersModuleUnitTestCase {
    @Test
    void create_a_valid_user() {
        UserRegister register = new UserRegister(repository, eventBus, encoder);

        User                   user        = UserMother.random();
        UserCreatedDomainEvent domainEvent = UserCreatedDomainEventMother.create(user);

        mockPasswordEncode(user.password().value());

        register.create(user.id(), user.name(), user.lastname(), user.username(), user.email(), user.password(), user.profilePhotoUrl(), user.phone(), user.roleId());

        shouldSave(user);
        shouldHaveSaved(user);
        shouldHavePublished(domainEvent);
    }

    @Test
    void should_throws_exception_create_a_exists_user() {
        UserRegister register = new UserRegister(repository, eventBus, encoder);

        User                   user        = UserMother.random();
        UserCreatedDomainEvent domainEvent = UserCreatedDomainEventMother.create(user);

        Assertions.assertThrows(UserExists.class, () -> {
            mockRepositoryFindById(user);
            mockRepositoryFindByUsername(user);
            mockPasswordEncode(user.password().value());

            register.create(user.id(), user.name(), user.lastname(), user.username(), user.email(), user.password(), user.profilePhotoUrl(), user.phone(), user.roleId());

            shouldSave(user);
            shouldHaveSaved(user);
            shouldHavePublished(domainEvent);
        });
    }

    @Test
    void should_throws_exception_create_user_with_a_exists_username() {
        UserRegister register = new UserRegister(repository, eventBus, encoder);

        User                   user        = UserMother.random();
        UserCreatedDomainEvent domainEvent = UserCreatedDomainEventMother.create(user);

        Assertions.assertThrows(UserExists.class, () -> {
            mockRepositoryFindByUsername(user);
            mockPasswordEncode(user.password().value());

            register.create(user.id(), user.name(), user.lastname(), user.username(), user.email(), user.password(), user.profilePhotoUrl(), user.phone(), user.roleId());

            shouldSave(user);
            shouldHaveSaved(user);
            shouldHavePublished(domainEvent);
        });
    }
}
