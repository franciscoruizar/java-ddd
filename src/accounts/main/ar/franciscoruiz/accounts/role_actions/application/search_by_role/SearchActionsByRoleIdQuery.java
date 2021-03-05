package ar.franciscoruiz.accounts.role_actions.application.search_by_role;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchActionsByRoleIdQuery implements Query {
    private final String roleId;

    public SearchActionsByRoleIdQuery(String roleId) {
        this.roleId = roleId;
    }

    public String roleId() {
        return roleId;
    }
}
