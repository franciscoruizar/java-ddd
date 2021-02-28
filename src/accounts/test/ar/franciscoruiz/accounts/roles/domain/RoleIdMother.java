package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class RoleIdMother {
    public static RoleId create(String value) {
        return new RoleId(value);
    }

    public static RoleId random() {
        return create(UuidMother.random());
    }

}
