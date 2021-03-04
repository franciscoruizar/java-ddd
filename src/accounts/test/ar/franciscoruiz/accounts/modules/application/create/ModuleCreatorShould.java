package ar.franciscoruiz.accounts.modules.application.create;

import ar.franciscoruiz.accounts.modules.ModulesModuleUnitTestCase;
import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleMother;
import org.junit.jupiter.api.Test;

final class ModuleCreatorShould extends ModulesModuleUnitTestCase {
    @Test
    void create_a_valid_module() {
        ModuleCreator creator = new ModuleCreator(repository);

        Module module = ModuleMother.random();

        creator.create(module.id(), module.name());

        shouldSave(module);
        shouldHaveSaved(module);
    }
}
