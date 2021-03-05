package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class ActionName extends StringValueObject {
    public ActionName(String value) {
        super(value);
    }

    private ActionName() {
        super(null);
    }
}
