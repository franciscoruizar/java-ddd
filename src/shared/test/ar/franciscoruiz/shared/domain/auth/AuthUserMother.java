package ar.franciscoruiz.shared.domain.auth;

public final class AuthUserMother {
    public static AuthUser create(AuthUsername username, AuthPassword password, Authorities authorities) {
        return new AuthUser(username, password, authorities);
    }

    public static AuthUser random() {
        return create(AuthUsernameMother.random(), AuthPasswordMother.random(), AuthoritiesMother.random());
    }
}
