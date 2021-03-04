package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class UserNotExist extends DomainError {
    public UserNotExist(UserId id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id.value()));
    }

    public UserNotExist(UserUsername username) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", username.value()));
    }

    public UserNotExist(UserEmail email) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", email.value()));
    }
}
