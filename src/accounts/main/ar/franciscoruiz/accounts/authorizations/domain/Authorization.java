package ar.franciscoruiz.accounts.authorizations.domain;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

public final class Authorization {
    private final RoleId   roleId;
    private final ActionId actionId;

    public Authorization(RoleId roleId, ActionId actionId) {
        this.roleId   = roleId;
        this.actionId = actionId;
    }

    public RoleId roleId() {
        return roleId;
    }

    public ActionId actionId() {
        return actionId;
    }
}
