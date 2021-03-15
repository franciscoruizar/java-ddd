package ar.franciscoruiz.accounts.modules.infrastructure;

import ar.franciscoruiz.accounts.modules.ModulesModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleIdMother;
import ar.franciscoruiz.accounts.modules.domain.ModuleMother;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
final class HibernateModuleRepositoryShould extends ModulesModuleInfrastructureTestCase {

    @Test
    void persist() {
        for (var item : entities()) {
            repository.save(item);
        }
    }

    @Test
    void return_an_existing() {
        for (var item : entities()) {
            repository.save(item);

            Assertions.assertEquals(Optional.of(item), repository.findById(item.id()));
        }
    }

    @Test
    void not_return_a_non_existing() {
        Assertions.assertFalse(repository.findById(ModuleIdMother.random()).isPresent());
    }

    private List<Module> entities() {
        Random       random   = new Random();
        int          total    = random.nextInt(5);
        List<Module> entities = new ArrayList<>();
        for (int i = 0; i < total; i++)
            entities.add(ModuleMother.random());

        return entities;
    }
}
