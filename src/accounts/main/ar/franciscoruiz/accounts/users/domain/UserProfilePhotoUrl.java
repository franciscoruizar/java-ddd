package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.vo.UrlValueObject;

public final class UserProfilePhotoUrl extends UrlValueObject {
    public UserProfilePhotoUrl(String value) {
        super(value);
    }

    private UserProfilePhotoUrl() {
        super(null);
    }
}
