package ar.franciscoruiz.accounts.actions;

import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class ActionsModuleUnitTestCase extends UnitTestCase {
    protected ActionRepository repository;
    protected ModuleRepository moduleRepository;

    @Override
    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository       = mock(ActionRepository.class);
        moduleRepository = mock(ModuleRepository.class);
    }

    public void shouldSave(Action entity) {
        this.repository.save(entity);
    }

    public void shouldHaveSaved(Action entity) {
        verify(repository, atLeastOnce()).save(entity);
    }

    public void mockRepositoryFindById(Action entity) {
        Mockito.when(repository.findById(entity.id())).thenReturn(Optional.of(entity));
    }

    public void shouldSaveModule(Module entity) {
        this.moduleRepository.save(entity);
    }

    public void shouldHaveSavedModule(Module entity) {
        verify(moduleRepository, atLeastOnce()).save(entity);
    }

    public void mockModuleRepositoryFindById(Module entity) {
        Mockito.when(moduleRepository.findById(entity.id())).thenReturn(Optional.of(entity));
    }
}
