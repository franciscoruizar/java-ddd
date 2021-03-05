package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class ActionIdMother {
    public static ActionId create(String value) {
        return new ActionId(value);
    }

    public static ActionId random() {
        return create(UuidMother.random());
    }
}
