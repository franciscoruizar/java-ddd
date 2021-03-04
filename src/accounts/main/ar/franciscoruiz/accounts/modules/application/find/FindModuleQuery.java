package ar.franciscoruiz.accounts.modules.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindModuleQuery implements Query {
    private final String id;

    public FindModuleQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
