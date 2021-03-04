package ar.franciscoruiz.accounts.modules.application.find;

import ar.franciscoruiz.accounts.modules.ModulesModuleUnitTestCase;
import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleMother;
import org.junit.jupiter.api.Test;

final class ModuleFinderShould extends ModulesModuleUnitTestCase {
    @Test
    void find_a_valid_module() {
        ModuleFinder finder = new ModuleFinder(repository);

        Module module = ModuleMother.random();

        mockRepositoryFindById(module);

        finder.find(module.id());
    }
}
