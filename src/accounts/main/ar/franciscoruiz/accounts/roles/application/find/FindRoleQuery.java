package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindRoleQuery implements Query {
    private final String id;

    public FindRoleQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
