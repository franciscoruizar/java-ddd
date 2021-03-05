package ar.franciscoruiz.accounts.role_actions.application.create;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateRoleActionCommandHandler implements CommandHandler<CreateRoleActionCommand> {
    private final RoleActionCreator creator;

    public CreateRoleActionCommandHandler(RoleActionCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateRoleActionCommand command) {
        RoleId   roleId   = new RoleId(command.roleId());
        ActionId actionId = new ActionId(command.actionId());

        this.creator.create(roleId, actionId);
    }
}
