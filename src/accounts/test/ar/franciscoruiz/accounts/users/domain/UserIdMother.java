package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class UserIdMother {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return create(UuidMother.random());
    }
}
