package ar.franciscoruiz.accounts.users.application.find;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindUserQuery implements Query {
    private final String id;

    public FindUserQuery(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
