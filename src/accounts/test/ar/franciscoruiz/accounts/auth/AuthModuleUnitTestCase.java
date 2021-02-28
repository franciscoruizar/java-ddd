package ar.franciscoruiz.accounts.auth;

import ar.franciscoruiz.accounts.auth.domain.AuthRepository;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public abstract class AuthModuleUnitTestCase extends UnitTestCase {
    protected AuthRepository  repository;
    protected PasswordEncoder encoder;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(AuthRepository.class);

        encoder = mock(PasswordEncoder.class);
    }

    public void mockRepositorySearch(AuthUser entity) {
        Mockito.when(repository.search(entity.username())).thenReturn(Optional.of(entity));
    }

    public void mockPasswordEncoderEncode(String rawPassword) {
        Mockito.when(encoder.encode(rawPassword)).thenReturn(rawPassword);
    }

    public void mockPasswordEncoderMatch(String rawPassword, String encodedPassword) {
        Mockito.when(encoder.matches(rawPassword, encodedPassword)).thenReturn(rawPassword.equals(encodedPassword));
    }
}
