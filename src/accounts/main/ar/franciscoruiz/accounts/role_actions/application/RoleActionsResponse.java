package ar.franciscoruiz.accounts.role_actions.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class RoleActionsResponse implements Response {
    private final List<RoleActionResponse> values;

    public RoleActionsResponse(List<RoleActionResponse> values) {
        this.values = values;
    }

    public List<RoleActionResponse> values() {
        return values;
    }
}
