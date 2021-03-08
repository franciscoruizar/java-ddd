package ar.franciscoruiz.accounts.actions.infrastructure;

import ar.franciscoruiz.accounts.actions.ActionsModuleInfrastructureTestCase;
import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionIdMother;
import ar.franciscoruiz.accounts.actions.domain.ActionMother;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Transactional
final class HibernateActionRepositoryShould extends ActionsModuleInfrastructureTestCase {

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
        Assertions.assertFalse(repository.findById(ActionIdMother.random()).isPresent());
    }

    private List<Action> entities() {
        Random       random   = new Random();
        int          total    = random.nextInt(5);
        List<Action> entities = new ArrayList<>();
        var          modules  = moduleRepository.search(new Criteria(Filters.none(), Order.none())).subList(0, total);
        for (int i = 0; i < total; i++) {
            var action = ActionMother.random();
            entities.add(ActionMother.create(action.id(), action.name(), modules.get(i).id()));
        }
        return entities;
    }
}
