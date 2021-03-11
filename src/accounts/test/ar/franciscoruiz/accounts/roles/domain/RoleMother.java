package ar.franciscoruiz.accounts.roles.domain;

public final class RoleMother {
    public static Role create(RoleId id, RoleName name) {
        return new Role(id, name);
    }

    public static Role random() {
        return create(RoleIdMother.random(), RoleNameMother.random());
    }
}
