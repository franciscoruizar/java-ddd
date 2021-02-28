package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class UserLastnameMother {
    public static UserLastname create(String value) {
        return new UserLastname(value);
    }

    public static UserLastname random() {
        return create(WordMother.random());
    }
}
