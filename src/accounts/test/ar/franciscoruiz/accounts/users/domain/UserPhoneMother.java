package ar.franciscoruiz.accounts.users.domain;

public final class UserPhoneMother {
    public static UserPhone create(String value) {
        return new UserPhone(value);
    }

    public static UserPhone random() {
        return create("+54 11-0000-9935");
    }
}
