package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ActionRepository {
    void save(Action action);

    Optional<Action> findById(ActionId id);

    List<Action> search(Criteria criteria);
}

