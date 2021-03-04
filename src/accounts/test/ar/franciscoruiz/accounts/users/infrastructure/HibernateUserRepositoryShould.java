package ar.franciscoruiz.accounts.users.infrastructure;

import ar.franciscoruiz.accounts.users.UsersModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserIdMother;
import ar.franciscoruiz.accounts.users.domain.UserMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
final class HibernateUserRepositoryShould extends UsersModuleInfrastructureTestCase {

    @Test
    void persist() {
        for (var item : entities()) {
            repository.save(item);
        }
    }

    @Test
    void return_an_existing() {
        for (var item : entities()) {
            repository.save(item);

            Assertions.assertEquals(Optional.of(item), repository.findById(item.id()));
        }
    }

    @Test
    void not_return_a_non_existing() {
        Assertions.assertFalse(repository.findById(UserIdMother.random()).isPresent());
    }

    private List<User> entities() {
        Random     random   = new Random();
        int        total    = random.nextInt(5);
        List<User> entities = new ArrayList<>();
        for (int i = 0; i < total; i++)
             entities.add(UserMother.random());

        return entities;
    }
}
