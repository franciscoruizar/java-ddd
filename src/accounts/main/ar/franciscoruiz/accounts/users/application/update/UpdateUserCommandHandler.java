package ar.franciscoruiz.accounts.users.application.update;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand> {
    private final UserUpdater creator;

    public UpdateUserCommandHandler(UserUpdater creator) {
        this.creator = creator;
    }

    @Override
    public void handle(UpdateUserCommand command) {
        UserId              id              = new UserId(command.id());
        UserName            name            = new UserName(command.name());
        UserLastname        lastname        = new UserLastname(command.lastname());
        UserUsername        username        = new UserUsername(command.username());
        UserEmail           email           = new UserEmail(command.email());
        UserProfilePhotoUrl profilePhotoUrl = new UserProfilePhotoUrl(command.profilePhotoUrl());
        UserPhone           phone           = new UserPhone(command.phone());
        RoleId              roleId          = new RoleId(command.roleId());

        this.creator.update(id, name, lastname, username, email, profilePhotoUrl, phone, roleId);
    }
}
