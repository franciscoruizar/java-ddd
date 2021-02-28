package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class RoleId extends Identifier {
    public RoleId(String value) {
        super(value);
    }

    private RoleId() {
    }
}
