package ar.franciscoruiz.accounts.authentications.application.authenticate;

import ar.franciscoruiz.accounts.authentications.domain.AuthPassword;
import ar.franciscoruiz.accounts.authentications.domain.AuthUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class AuthenticateUserCommandHandler implements CommandHandler<AuthenticateUserCommand> {
    private final AuthUserAuthenticator authenticator;

    public AuthenticateUserCommandHandler(AuthUserAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public void handle(AuthenticateUserCommand command) {
        AuthUsername username = new AuthUsername(command.username());
        AuthPassword password = new AuthPassword(command.password());

        authenticator.authenticate(username, password);
    }
}
