package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthUsername;

public final class InvalidAuthCredentials extends RuntimeException {
    public InvalidAuthCredentials(AuthUsername username) {
        super(String.format("The credentials for <%s> are invalid", username.value()));
    }
}
