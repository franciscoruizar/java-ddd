package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.MotherCreator;

public final class UserProfilePhotoUrlMother {
    public static UserProfilePhotoUrl create(String value) {
        return new UserProfilePhotoUrl(value);
    }

    public static UserProfilePhotoUrl random() {
        return create(MotherCreator.random().avatar().image());
    }
}
