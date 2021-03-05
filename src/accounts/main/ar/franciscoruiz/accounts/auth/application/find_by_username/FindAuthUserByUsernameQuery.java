package ar.franciscoruiz.accounts.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class FindAuthUserByUsernameQuery implements Query {
    private final String username;

    public FindAuthUserByUsernameQuery(String username) {
        this.username = username;
    }

    public String username() {
        return username;
    }
}
