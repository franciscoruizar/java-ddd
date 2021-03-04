package ar.franciscoruiz.accounts.auth.infrastructure.persistence;

import ar.franciscoruiz.accounts.auth.domain.AuthRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;
import ar.franciscoruiz.shared.domain.criteria.*;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Optional;

@Service
public final class HibernateAuthRepository extends HibernateRepository<AuthUser> implements AuthRepository {
    public HibernateAuthRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, AuthUser.class);
    }

    @Override
    public Optional<AuthUser> search(AuthUsername username) {
        Filters filters = new Filters(new ArrayList<>() {{
            add(new Filter(new FilterField("username"), FilterOperator.EQUAL, new FilterValue(username.value())));
        }});
        Order    order    = Order.none();
        Criteria criteria = new Criteria(filters, order);
        return this.byCriteria(criteria).stream().findFirst();
    }
}
