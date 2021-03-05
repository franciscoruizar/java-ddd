package ar.franciscoruiz.accounts.modules.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class ModulesResponse implements Response {
    private final List<ModuleResponse> values;

    public ModulesResponse(List<ModuleResponse> values) {
        this.values = values;
    }

    public List<ModuleResponse> values() {
        return values;
    }
}
