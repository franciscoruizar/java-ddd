package ar.franciscoruiz.accounts.authorizations.application.create;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateAuthorizationCommandHandler implements CommandHandler<CreateAuthorizationCommand> {
    private final AuthorizationCreator creator;

    public CreateAuthorizationCommandHandler(AuthorizationCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateAuthorizationCommand command) {
        RoleId   roleId   = new RoleId(command.roleId());
        ActionId actionId = new ActionId(command.actionId());

        this.creator.create(roleId, actionId);
    }
}
