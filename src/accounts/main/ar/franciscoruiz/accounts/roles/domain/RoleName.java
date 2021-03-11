package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class RoleName extends StringValueObject {
    public RoleName(String value) {
        super(value);
    }

    private RoleName() {
        super(null);
    }
}
