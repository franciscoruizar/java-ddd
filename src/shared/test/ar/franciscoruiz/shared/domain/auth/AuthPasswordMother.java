package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.WordMother;

public final class AuthPasswordMother {
    public static AuthPassword create(String value) throws Exception {
        return new AuthPassword(value);
    }

    public static AuthPassword random() throws Exception {
        return create(WordMother.random());
    }
}
