package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.accounts.roles.RolesModuleUnitTestCase;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleMother;
import org.junit.jupiter.api.Test;

final class RoleFinderShould extends RolesModuleUnitTestCase {
    @Test
    void find_a_valid_role() {
        RoleFinder finder = new RoleFinder(repository);

        Role role = RoleMother.random();

        mockRepositoryFindById(role);

        finder.find(role.id());
    }
}
