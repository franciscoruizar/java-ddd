package ar.franciscoruiz.shared.domain.auth;

import java.util.Objects;

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
        return username;
    }

    public AuthPassword password() {
        return password;
    }

    public Authorities authorities() {
        return authorities;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (AuthUser) obj;
        return Objects.equals(this.username, that.username) &&
            Objects.equals(this.password, that.password) &&
            Objects.equals(this.authorities, that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, authorities);
    }

    @Override
    public String toString() {
        return "AuthUser[" +
            "username=" + username + ", " +
            "password=" + password + ", " +
            "authorities=" + authorities + ']';
    }

}
