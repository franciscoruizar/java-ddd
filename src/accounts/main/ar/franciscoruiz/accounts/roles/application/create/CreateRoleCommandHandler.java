package ar.franciscoruiz.accounts.roles.application.create;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleName;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateRoleCommandHandler implements CommandHandler<CreateRoleCommand> {
    private final RoleCreator creator;

    public CreateRoleCommandHandler(RoleCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateRoleCommand command) {
        RoleId   id   = new RoleId(command.id());
        RoleName name = new RoleName(command.name());

        this.creator.create(id, name);
    }
}
