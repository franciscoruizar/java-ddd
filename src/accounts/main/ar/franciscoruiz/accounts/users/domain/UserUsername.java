package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserUsername extends StringValueObject {
    public UserUsername(String value) {
        super(value);
    }

    private UserUsername() {
        super(null);
    }
}
