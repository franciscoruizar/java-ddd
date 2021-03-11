package ar.franciscoruiz.accounts.authorizations.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateAuthorizationCommand implements Command {
    private final String roleId;
    private final String actionId;

    public CreateAuthorizationCommand(String roleId, String actionId) {
        this.roleId   = roleId;
        this.actionId = actionId;
    }

    public String roleId() {
        return roleId;
    }

    public String actionId() {
        return actionId;
    }
}
