package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.PhoneValueObject;

public final class UserPhone extends PhoneValueObject {
    public UserPhone(String value) {
        super(value);
    }

    private UserPhone() {
        super(null);
    }
}
