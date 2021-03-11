package ar.franciscoruiz.accounts.roles;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class RolesModuleUnitTestCase extends UnitTestCase {
    protected RoleRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(RoleRepository.class);
    }

    public void shouldSave(Role entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Role entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositoryFindById(Role entity) {
        Mockito.when(repository.findById(entity.id())).thenReturn(Optional.of(entity));
    }
}
