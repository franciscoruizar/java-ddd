package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class UserUsernameMother {
    public static UserUsername create(String value) {
        return new UserUsername(value);
    }

    public static UserUsername random() {
        return create(WordMother.random());
    }
}
