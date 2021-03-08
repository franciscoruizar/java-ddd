package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.accounts.modules.domain.ModuleId;

import java.util.Objects;

public final class Action {
    private final ActionId     id;
    private final ActionMethod method;
    private final ModuleId     moduleId;

    public Action(ActionId id, ActionMethod method, ModuleId moduleId) {
        this.id       = id;
        this.method   = method;
        this.moduleId = moduleId;
    }

    private Action() {
        this.id       = null;
        this.method   = null;
        this.moduleId = null;
    }

    public ActionId id() {
        return id;
    }

    public ActionMethod method() {
        return method;
    }

    public ModuleId moduleId() {
        return moduleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return Objects.equals(id, action.id) && Objects.equals(method, action.method) && Objects.equals(moduleId, action.moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method, moduleId);
    }
}
