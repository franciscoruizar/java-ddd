package ar.franciscoruiz.accounts.authentications.infrastructure.persistence;

import ar.franciscoruiz.accounts.authentications.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class HibernateAuthRepository extends HibernateRepository<AuthUser> implements AuthRepository {
    public HibernateAuthRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, AuthUser.class);
    }

    @Override
    public Optional<AuthUser> search(AuthUsername username) {
        String sql   = String.format("SELECT username, password, role_id FROM users WHERE username='%s'", username.value());
        Query  query = sessionFactory.getCurrentSession().createNativeQuery(sql);

        List<Object[]> result = query.getResultList();

        sessionFactory.getCurrentSession().clear();

        if (result.size() == 0) {
            return Optional.empty();
        }

        String sqlRole   = String.format("SELECT name FROM roles WHERE id='%s'", result.get(0)[2]);
        Query  queryRole = sessionFactory.getCurrentSession().createNativeQuery(sqlRole);

        List<String> resultRoles = queryRole.getResultList();

        if (result.size() == 0)
            return Optional.empty();

        return Optional.of(new AuthUser(
            new AuthUsername((String) result.get(0)[0]),
            new AuthPassword((String) result.get(0)[1]),
            new Authority(resultRoles.get(0))
        ));
    }
}
