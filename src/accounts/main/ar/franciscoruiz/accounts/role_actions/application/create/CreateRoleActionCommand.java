package ar.franciscoruiz.accounts.role_actions.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateRoleActionCommand implements Command {
    private final String roleId;
    private final String actionId;

    public CreateRoleActionCommand(String roleId, String actionId) {
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
