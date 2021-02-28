package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    private UserName() {
        super(null);
    }
}
