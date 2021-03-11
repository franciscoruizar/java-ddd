package ar.franciscoruiz.accounts.authentications.application.authenticate;

import ar.franciscoruiz.accounts.authentications.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;

import java.util.Optional;

@Service
public final class AuthUserAuthenticator {
    private final AuthRepository  repository;
    private final PasswordEncoder encoder;

    public AuthUserAuthenticator(AuthRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder    = encoder;
    }

    public void authenticate(AuthUsername username, AuthPassword password) {
        Optional<AuthUser> auth = repository.search(username);

        ensureUserExist(auth, username);
        ensureCredentialsAreValid(auth.get(), password);
    }

    private void ensureUserExist(Optional<AuthUser> auth, AuthUsername username) {
        if (auth.isEmpty()) {
            throw new InvalidAuthUsername(username);
        }
    }

    private void ensureCredentialsAreValid(AuthUser auth, AuthPassword password) {
        if (!encoder.matches(password.value(), auth.password().value())) {
            throw new InvalidAuthCredentials(auth.username());
        }
    }
}
