package ar.franciscoruiz.accounts.authentications.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class InvalidAuthCredentials extends DomainError {
    public InvalidAuthCredentials(AuthUsername username) {
        super("invalid_credentials", String.format("The credentials for <%s> are invalid", username.value()));
    }
}
