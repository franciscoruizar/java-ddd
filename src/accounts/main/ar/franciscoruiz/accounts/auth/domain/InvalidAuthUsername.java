package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthUsername;

public final class InvalidAuthUsername extends RuntimeException {
    public InvalidAuthUsername(AuthUsername username) {
        super(String.format("The user <%s> does not exist", username.value()));
    }
}
