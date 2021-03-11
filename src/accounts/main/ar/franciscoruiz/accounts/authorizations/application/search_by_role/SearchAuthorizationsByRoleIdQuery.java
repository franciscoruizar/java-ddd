package ar.franciscoruiz.accounts.authorizations.application.search_by_role;

import ar.franciscoruiz.shared.domain.bus.query.Query;

public final class SearchAuthorizationsByRoleIdQuery implements Query {
    private final String roleId;

    public SearchAuthorizationsByRoleIdQuery(String roleId) {
        this.roleId = roleId;
    }

    public String roleId() {
        return roleId;
    }
}
