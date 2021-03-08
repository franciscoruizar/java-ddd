package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleIdMother;

public final class ActionMother {
    public static Action create(ActionId id, ActionMethod name, ModuleId moduleId) {
        return new Action(id, name, moduleId);
    }

    public static Action random() {
        return create(ActionIdMother.random(), ActionNameMother.random(), ModuleIdMother.random());
    }
}
