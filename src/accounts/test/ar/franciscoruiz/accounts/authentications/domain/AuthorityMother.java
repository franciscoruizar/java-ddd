package ar.franciscoruiz.accounts.authentications.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleMother;

public final class AuthorityMother {
    public static Authority create(String value) {
        return new Authority(value);
    }

    public static Authority random() {
        return create(RoleMother.random().name().value());
    }
}
