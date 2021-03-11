package ar.franciscoruiz.accounts.modules.application;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class ModuleResponse implements Response {
    private final String id;
    private final String endpoint;

    public ModuleResponse(String id, String endpoint) {
        this.id       = id;
        this.endpoint = endpoint;
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

    public String endpoint() {
        return endpoint;
    }
}
