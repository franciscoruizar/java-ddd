package ar.franciscoruiz.accounts.roles.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class RolesResponse implements Response {
    private final List<RoleResponse> values;

    public RolesResponse(List<RoleResponse> values) {
        this.values = values;
    }

    public List<RoleResponse> values() {
        return values;
    }
}
