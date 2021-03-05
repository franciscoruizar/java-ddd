package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;

public final class InvalidAuthCredentials extends DomainError {
    public InvalidAuthCredentials(AuthUsername username) {
        super("invalid_credentials", String.format("The credentials for <%s> are invalid", username.value()));
    }
}
