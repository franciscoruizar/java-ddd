package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class RoleNameMother {
    public static RoleName create(String value) {
        return new RoleName(value);
    }

    public static RoleName random() {
        return create(WordMother.random());
    }
}
