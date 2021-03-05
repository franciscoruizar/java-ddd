package ar.franciscoruiz.accounts.role_actions.domain;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

public final class RoleAction {
    private final RoleId   roleId;
    private final ActionId actionId;

    public RoleAction(RoleId roleId, ActionId actionId) {
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
