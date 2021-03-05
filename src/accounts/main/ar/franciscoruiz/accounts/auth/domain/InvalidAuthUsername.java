package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;

public final class InvalidAuthUsername extends DomainError {
    public InvalidAuthUsername(AuthUsername username) {
        super("invalid_username", String.format("The user <%s> does not exist", username.value()));
    }
}
