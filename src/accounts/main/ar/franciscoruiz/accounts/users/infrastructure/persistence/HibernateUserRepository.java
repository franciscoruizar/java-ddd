package ar.franciscoruiz.accounts.users.infrastructure.persistence;

import ar.franciscoruiz.accounts.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public final class HibernateUserRepository extends HibernateRepository<User> implements UserRepository {
    public HibernateUserRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public List<User> search(Criteria criteria) {
        return byCriteria(criteria);
    }

    @Override
    public Optional<User> findByEmail(UserEmail email) {
        Filters filters = new Filters(new ArrayList<>() {{
            add(new Filter(new FilterField("email"), FilterOperator.EQUAL, new FilterValue(email.value())));
        }});
        Order    order    = Order.none();
        Criteria criteria = new Criteria(filters, order);

        return byCriteria(criteria).stream().findFirst();
    }

    @Override
    public Optional<User> findByUsername(UserUsername username) {
        Filters filters = new Filters(new ArrayList<>() {{
            add(new Filter(new FilterField("username"), FilterOperator.EQUAL, new FilterValue(username.value())));
        }});
        Order    order    = Order.none();
        Criteria criteria = new Criteria(filters, order);

        return byCriteria(criteria).stream().findFirst();
    }

    @Override
    public Optional<User> findById(UserId id) {
        return Optional.empty();
    }
}
