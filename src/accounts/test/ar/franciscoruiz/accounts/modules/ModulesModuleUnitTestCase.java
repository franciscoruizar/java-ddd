package ar.franciscoruiz.accounts.modules;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ModulesModuleUnitTestCase extends UnitTestCase {
    protected ModuleRepository repository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(ModuleRepository.class);
    }

    public void shouldSave(Module entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Module entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositoryFindById(Module entity) {
        Mockito.when(repository.findById(entity.id())).thenReturn(Optional.of(entity));
    }
}
