package ar.franciscoruiz.accounts.roles.application.create;

import ar.franciscoruiz.accounts.roles.RolesModuleUnitTestCase;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleMother;
import ar.franciscoruiz.accounts.roles.domain.RoleNotExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class RoleCreatorShould extends RolesModuleUnitTestCase {
    @Test
    void create_a_valid_role() {
        RoleCreator creator = new RoleCreator(repository);

        Role role = RoleMother.random();

        creator.create(role.id(), role.name());

        shouldSave(role);
        shouldHaveSaved(role);
    }

    @Test
    void should_throws_module_exception_create_a_non_valid_role() {
        RoleCreator creator = new RoleCreator(repository);

        Role role = RoleMother.random();

        Assertions.assertThrows(RoleNotExist.class, () -> {
            creator.create(role.id(), role.name());

            shouldSave(role);
            shouldHaveSaved(role);
        });
    }
}
