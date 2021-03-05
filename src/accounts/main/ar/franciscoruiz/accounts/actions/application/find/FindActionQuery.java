package ar.franciscoruiz.accounts.actions.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindActionQuery implements Query {
    private final String id;

    public FindActionQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
