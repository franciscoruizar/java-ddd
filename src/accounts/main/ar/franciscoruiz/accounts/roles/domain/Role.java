package ar.franciscoruiz.accounts.roles.domain;

import java.util.Objects;

public final class Role {
    private final RoleId   id;
    private final RoleName name;

    public Role(RoleId id, RoleName name) {
        this.id   = id;
        this.name = name;
    }

    private Role() {
        //Only for Hibernate
        this.id   = null;
        this.name = null;
    }

    public RoleId id() {
        return id;
    }

    public RoleName name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
