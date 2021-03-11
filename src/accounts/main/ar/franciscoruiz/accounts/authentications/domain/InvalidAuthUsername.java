package ar.franciscoruiz.accounts.authentications.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class InvalidAuthUsername extends DomainError {
    public InvalidAuthUsername(AuthUsername username) {
        super("invalid_username", String.format("The user <%s> does not exist", username.value()));
    }
}
