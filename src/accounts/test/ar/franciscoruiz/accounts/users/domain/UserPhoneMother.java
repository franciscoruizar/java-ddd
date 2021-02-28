package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.PhoneNumberMother;

public final class UserPhoneMother {
    public static UserPhone create(String value) {
        return new UserPhone(value);
    }

    public static UserPhone random() {
        return create(PhoneNumberMother.random());
    }
}
