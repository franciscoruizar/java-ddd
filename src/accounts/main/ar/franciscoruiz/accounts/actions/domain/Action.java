package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.accounts.modules.domain.ModuleId;

import java.util.Objects;

public final class Action {
    private final ActionId   id;
    private final ActionName name;
    private final ModuleId   moduleId;

    public Action(ActionId id, ActionName name, ModuleId moduleId) {
        this.id       = id;
        this.name     = name;
        this.moduleId = moduleId;
    }

    private Action() {
        this.id       = null;
        this.name     = null;
        this.moduleId = null;
    }

    public ActionId id() {
        return id;
    }

    public ActionName name() {
        return name;
    }

    public ModuleId moduleId() {
        return moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(id, action.id) && Objects.equals(name, action.name) && Objects.equals(moduleId, action.moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, moduleId);
    }
}
