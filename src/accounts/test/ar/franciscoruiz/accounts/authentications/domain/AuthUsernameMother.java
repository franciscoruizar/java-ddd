package ar.franciscoruiz.accounts.authentications.domain;

import ar.franciscoruiz.shared.domain.EmailMother;

public final class AuthUsernameMother {
    public static AuthUsername create(String value) {
        return new AuthUsername(value);
    }

    public static AuthUsername random() {
        return create(EmailMother.random());
    }
}
