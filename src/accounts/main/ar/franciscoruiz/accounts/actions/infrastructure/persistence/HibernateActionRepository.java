package ar.franciscoruiz.accounts.actions.infrastructure.persistence;

import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class HibernateActionRepository extends HibernateRepository<Action> implements ActionRepository {
    public HibernateActionRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Action.class);
    }

    @Override
    public void save(Action action) {
        persist(action);
    }

    @Override
    public Optional<Action> findById(ActionId id) {
        return byId(id);
    }

    @Override
    public List<Action> search(Criteria criteria) {
        return byCriteria(criteria);
    }
}
