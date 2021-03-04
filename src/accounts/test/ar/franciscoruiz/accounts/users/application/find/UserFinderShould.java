package ar.franciscoruiz.accounts.users.application.find;

import ar.franciscoruiz.accounts.users.UsersModuleUnitTestCase;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserMother;
import org.junit.jupiter.api.Test;

final class UserFinderShould extends UsersModuleUnitTestCase {
    @Test
    void find_a_valid_user() {
        UserFinder finder = new UserFinder(repository);

        User user = UserMother.random();

        mockRepositoryFindById(user);

        finder.find(user.id());
    }
}
