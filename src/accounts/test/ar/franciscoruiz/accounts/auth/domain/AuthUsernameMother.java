package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.EmailMother;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;

public final class AuthUsernameMother {
    public static AuthUsername create(String value) {
        return new AuthUsername(value);
    }

    public static AuthUsername random() {
        return create(EmailMother.random());
    }
}
