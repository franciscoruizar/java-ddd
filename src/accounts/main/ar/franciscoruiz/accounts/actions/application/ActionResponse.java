package ar.franciscoruiz.accounts.actions.application;

import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class ActionResponse implements Response {
    private final String id;
    private final String name;
    private final String moduleId;

    public ActionResponse(String id, String name, String moduleId) {
        this.id       = id;
        this.name     = name;
        this.moduleId = moduleId;
    }

    public static ActionResponse fromAggregate(Action action) {
        return new ActionResponse(
            action.id().value(),
            action.name().value(),
            action.moduleId().value()
        );
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String moduleId() {
        return moduleId;
    }
}
