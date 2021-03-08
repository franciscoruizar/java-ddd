package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class ActionNameMother {
    public static ActionMethod create(String value) {
        return new ActionMethod(value);
    }

    public static ActionMethod random() {
        return create(WordMother.random());
    }
}
