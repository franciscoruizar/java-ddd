package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class ActionMethod extends StringValueObject {
    public ActionMethod(String value) {
        super(value);
    }

    private ActionMethod() {
        super(null);
    }
}
