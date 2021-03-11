package ar.franciscoruiz.accounts.authentications.application.authenticate;

import ar.franciscoruiz.accounts.authentications.AuthModuleUnitTestCase;
import ar.franciscoruiz.accounts.authentications.domain.AuthUser;
import ar.franciscoruiz.accounts.authentications.domain.AuthUserMother;
import org.junit.jupiter.api.Test;

final class AuthUserAuthenticatorShould extends AuthModuleUnitTestCase {
    @Test
    void authenticate_a_valid_user() {
        AuthUserAuthenticator authenticator = new AuthUserAuthenticator(repository, encoder);

        AuthUser user = AuthUserMother.random();

        mockPasswordEncoderEncode(user.password().value());
        mockPasswordEncoderMatch(user.password().value(), user.password().value());

        super.mockRepositorySearch(user);

        authenticator.authenticate(user.username(), user.password());
    }
}
