package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthPassword;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;
import ar.franciscoruiz.shared.domain.auth.Authorities;

public final class AuthUserMother {
    public static AuthUser create(AuthUsername username, AuthPassword password, Authorities authorities) {
        return new AuthUser(username, password, authorities);
    }

    public static AuthUser random() {
        return create(AuthUsernameMother.random(), AuthPasswordMother.random(), AuthoritiesMother.random());
    }
}
