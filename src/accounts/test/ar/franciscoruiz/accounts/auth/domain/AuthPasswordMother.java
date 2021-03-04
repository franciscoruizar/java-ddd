package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.WordMother;
import ar.franciscoruiz.shared.domain.auth.AuthPassword;

public final class AuthPasswordMother {
    public static AuthPassword create(String value) {
        return new AuthPassword(value);
    }

    public static AuthPassword random() {
        return create(WordMother.random());
    }
}
