package ar.franciscoruiz.accounts.roles.application;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class RoleResponse implements Response {
    private final String id;
    private final String name;

    public RoleResponse(String id, String name) {
        this.id   = id;
        this.name = name;
    }

    public static RoleResponse fromAggregate(Role role) {
        return new RoleResponse(role.id().value(), role.name().value());
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }
}
