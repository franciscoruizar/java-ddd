package ar.franciscoruiz.accounts.users.application.updater;

import ar.franciscoruiz.accounts.users.UsersModuleUnitTestCase;
import ar.franciscoruiz.accounts.users.application.update.UserUpdater;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserExists;
import ar.franciscoruiz.accounts.users.domain.UserMother;
import ar.franciscoruiz.accounts.users.domain.UserNotExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class UserUpdaterShould extends UsersModuleUnitTestCase {
    @Test
    void update_a_valid_user() {
        UserUpdater updater = new UserUpdater(repository);

        User user = UserMother.random();

        mockRepositoryFindById(user);

        updater.update(user.id(), user.name(), user.lastname(), user.username(), user.email(), user.profilePhotoUrl(), user.phone(), user.roleId());

        shouldSave(user);
        shouldHaveSaved(user);
    }

    @Test
    void should_throws_exception_update_a_non_exists_user() {
        UserUpdater updater = new UserUpdater(repository);

        User user = UserMother.random();

        Assertions.assertThrows(UserNotExist.class, () -> {
            updater.update(user.id(), user.name(), user.lastname(), user.username(), user.email(), user.profilePhotoUrl(), user.phone(), user.roleId());

            shouldSave(user);
            shouldHaveSaved(user);
        });
    }

    @Test
    void should_throws_exception_update_user_with_a_exists_username() {
        UserUpdater updater = new UserUpdater(repository);

        User user = UserMother.random();

        Assertions.assertThrows(UserExists.class, () -> {
            mockRepositoryFindById(user);
            mockRepositoryFindByUsername(user);

            updater.update(user.id(), user.name(), user.lastname(), user.username(), user.email(), user.profilePhotoUrl(), user.phone(), user.roleId());

            shouldSave(user);
            shouldHaveSaved(user);
        });
    }
}
