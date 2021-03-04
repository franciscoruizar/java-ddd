package ar.franciscoruiz.accounts.users.domain;

public final class UserExists extends RuntimeException {
    public UserExists(UserId userId) {
        super(String.format("The user <%s> exists", userId.value()));
    }

    public UserExists(UserUsername username) {
        super(String.format("The username <%s> exists", username.value()));
    }
}
