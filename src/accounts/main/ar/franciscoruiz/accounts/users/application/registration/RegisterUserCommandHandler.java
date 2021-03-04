package ar.franciscoruiz.accounts.users.application.registration;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class RegisterUserCommandHandler implements CommandHandler<RegisterUserCommand> {
    private final UserRegister creator;

    public RegisterUserCommandHandler(UserRegister creator) {
        this.creator = creator;
    }

    @Override
    public void handle(RegisterUserCommand command) {
        UserId              id              = new UserId(command.id());
        UserName            name            = new UserName(command.name());
        UserLastname        lastname        = new UserLastname(command.lastname());
        UserUsername        username        = new UserUsername(command.username());
        UserEmail           email           = new UserEmail(command.email());
        UserPassword        password        = new UserPassword(command.password());
        UserProfilePhotoUrl profilePhotoUrl = new UserProfilePhotoUrl(command.profilePhotoUrl());
        UserPhone           phone           = new UserPhone(command.phone());
        RoleId              roleId          = new RoleId(command.roleId());

        this.creator.create(id, name, lastname, username, email, password, profilePhotoUrl, phone, roleId);
    }
}
