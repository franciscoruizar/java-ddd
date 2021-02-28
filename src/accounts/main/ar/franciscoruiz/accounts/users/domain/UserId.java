package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class UserId extends Identifier {
    public UserId(String value) {
        super(value);
    }

    private UserId() {
    }
}
