package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class ActionNameMother {
    public static ActionName create(String value) {
        return new ActionName(value);
    }

    public static ActionName random() {
        return create(WordMother.random());
    }
}
