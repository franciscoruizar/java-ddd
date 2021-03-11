package ar.franciscoruiz.accounts.actions.application.create;

import ar.franciscoruiz.accounts.actions.ActionsModuleUnitTestCase;
import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionMother;
import ar.franciscoruiz.accounts.modules.domain.ModuleMother;
import ar.franciscoruiz.accounts.modules.domain.ModuleNameMother;
import ar.franciscoruiz.accounts.modules.domain.ModuleNotExist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class ActionCreatorShould extends ActionsModuleUnitTestCase {
    @Test
    void create_a_valid_action() {
        ActionCreator creator = new ActionCreator(repository, moduleRepository);

        Action action = ActionMother.random();

        mockModuleRepositoryFindById(ModuleMother.create(action.moduleId(), ModuleNameMother.random()));

        creator.create(action.id(), action.method(), action.moduleId());

        shouldSave(action);
        shouldHaveSaved(action);
    }

    @Test
    void should_throws_module_exception_create_a_non_valid_action() {
        ActionCreator creator = new ActionCreator(repository, moduleRepository);

        Action action = ActionMother.random();

        Assertions.assertThrows(ModuleNotExist.class, () -> {
            creator.create(action.id(), action.method(), action.moduleId());

            shouldSave(action);
            shouldHaveSaved(action);
        });
    }
}
