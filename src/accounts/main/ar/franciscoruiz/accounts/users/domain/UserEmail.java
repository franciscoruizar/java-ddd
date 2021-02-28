package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.EmailValueObject;

public final class UserEmail extends EmailValueObject {
    public UserEmail(String value) {
        super(value);
    }

    private UserEmail() {
        super(null);
    }
}
