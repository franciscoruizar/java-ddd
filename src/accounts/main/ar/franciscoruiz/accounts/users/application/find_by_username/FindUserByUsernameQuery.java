package ar.franciscoruiz.accounts.users.application.find_by_username;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindUserByUsernameQuery implements Query {
    private final String username;

    public FindUserByUsernameQuery(String username) {
        this.username = username;
    }

    public String username() {
        return this.username;
    }
}
