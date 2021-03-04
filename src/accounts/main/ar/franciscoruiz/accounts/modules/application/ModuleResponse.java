package ar.franciscoruiz.accounts.modules.application;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class ModuleResponse implements Response {
    private final String id;
    private final String name;

    public ModuleResponse(String id, String name) {
        this.id   = id;
        this.name = name;
    }

    public static ModuleResponse fromAggregate(Module module) {
        return new ModuleResponse(
            module.id().value(),
            module.name().value()
        );
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }
}
