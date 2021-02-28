package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.EmailMother;

public final class UserEmailMother {
    public static UserEmail create(String value) {
        return new UserEmail(value);
    }

    public static UserEmail random() {
        return create(EmailMother.random());
    }
}
