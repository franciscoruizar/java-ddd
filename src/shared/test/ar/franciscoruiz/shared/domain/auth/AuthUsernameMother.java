package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.EmailMother;

public final class AuthUsernameMother {
    public static AuthUsername create(String value) throws Exception {
        return new AuthUsername(value);
    }

    public static AuthUsername random() throws Exception {
        return create(EmailMother.random());
    }
}
