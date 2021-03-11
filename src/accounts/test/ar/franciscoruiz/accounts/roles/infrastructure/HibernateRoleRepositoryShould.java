package ar.franciscoruiz.accounts.roles.infrastructure;

import ar.franciscoruiz.accounts.roles.RolesModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleIdMother;
import ar.franciscoruiz.accounts.roles.domain.RoleMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
final class HibernateRoleRepositoryShould extends RolesModuleInfrastructureTestCase {

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
        Assertions.assertFalse(repository.findById(RoleIdMother.random()).isPresent());
    }

    private List<Role> entities() {
        Random     random   = new Random();
        int        total    = random.nextInt(5);
        List<Role> entities = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            var role = RoleMother.random();
            entities.add(RoleMother.create(role.id(), role.name()));
        }
        return entities;
    }
}
