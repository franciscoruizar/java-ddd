package ar.franciscoruiz.accounts.roles.domain;

public final class RoleIdMother {
    public static RoleId random() {
        return RoleMother.random().value();
    }
}
