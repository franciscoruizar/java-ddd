package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserLastname extends StringValueObject {
    public UserLastname(String value) {
        super(value);
    }

    private UserLastname() {
        super(null);
    }
}
