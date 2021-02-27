package ar.franciscoruiz.shared.domain.auth;

public final class AuthUser {
    private final AuthUsername username;
    private final AuthPassword password;
    private final Authorities  authorities;

    public AuthUser(AuthUsername username, AuthPassword password, Authorities authorities) {
        this.username    = username;
        this.password    = password;
        this.authorities = authorities;
    }

    public AuthUsername username() {
        return this.username;
    }

    public AuthPassword password() {
        return this.password;
    }

    public Authorities authorities() {
        return this.authorities;
    }

    public boolean passwordMatches(AuthPassword password) {
        return this.password.equals(password);
    }
}
