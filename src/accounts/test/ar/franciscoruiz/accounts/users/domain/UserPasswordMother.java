package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class UserPasswordMother {
    public static UserPassword create(String value) {
        return new UserPassword(value);
    }

    public static UserPassword random() {
        return create(WordMother.random());
    }
}
