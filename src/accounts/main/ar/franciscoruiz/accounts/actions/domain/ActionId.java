package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class ActionId extends Identifier {
    public ActionId(String value) {
        super(value);
    }

    private ActionId() {
        super();
    }
}
