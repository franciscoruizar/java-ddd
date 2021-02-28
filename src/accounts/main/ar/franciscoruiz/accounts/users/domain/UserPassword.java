package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.PasswordValueObject;

public final class UserPassword extends PasswordValueObject {
    public UserPassword(String value) {
        super(value);
    }

    private UserPassword() {
        super(null);
    }
}
