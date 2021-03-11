package ar.franciscoruiz.accounts.authentications.domain;

public final class AuthUserMother {
    public static AuthUser create(AuthUsername username, AuthPassword password, Authority authority) {
        return new AuthUser(username, password, authority);
    }

    public static AuthUser random() {
        return create(AuthUsernameMother.random(), AuthPasswordMother.random(), AuthorityMother.random());
    }
}
