package ar.franciscoruiz.accounts.users;

import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class UsersModuleUnitTestCase extends UnitTestCase {
    protected UserRepository  repository;
    protected PasswordEncoder encoder;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(UserRepository.class);
        encoder    = mock(PasswordEncoder.class);
    }

    public void shouldSave(User entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(User entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositoryFindById(User entity) {
        Mockito.when(repository.findById(entity.id())).thenReturn(Optional.of(entity));
    }

    public void mockRepositoryFindByEmail(User entity) {
        Mockito.when(repository.findByEmail(entity.email())).thenReturn(Optional.of(entity));
    }

    public void mockRepositoryFindByUsername(User entity) {
        Mockito.when(repository.findByUsername(entity.username())).thenReturn(Optional.of(entity));
    }

    public void mockPasswordEncode(String rawPassword) {
        Mockito.when(encoder.encode(rawPassword)).thenReturn(rawPassword);
    }
}
