package ar.franciscoruiz.accounts.authorizations.infrastructure.persistence;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.authorizations.domain.Authorization;
import ar.franciscoruiz.accounts.authorizations.domain.AuthorizationRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class HibernateAuthorizationRepository extends HibernateRepository<Authorization> implements AuthorizationRepository {
    public HibernateAuthorizationRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Authorization.class);
    }

    @Override
    public void save(Authorization authorization) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
            "INSERT INTO authorizations (role_id, action_id) VALUES (:roleId, :actionId);"
        );

        query.setParameter("roleId", authorization.roleId().value())
            .setParameter("actionId", authorization.actionId().value());

        query.executeUpdate();
    }

    @Override
    public List<Authorization> searchByRoleId(RoleId roleId) {
        String sql   = String.format("SELECT role_id, action_id FROM authorizations WHERE role_id='%s'", roleId.value());
        Query  query = sessionFactory.getCurrentSession().createNativeQuery(sql);

        List<Object[]> results = query.list();

        sessionFactory.getCurrentSession().clear();

        return results.stream().map(objects -> new Authorization(
            new RoleId((String) objects[0]),
            new ActionId((String) objects[1])
        )).collect(Collectors.toList());
    }

    @Override
    public Optional<Authorization> find(RoleId roleId, ActionId actionId) {
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(
            "SELECT role_id, action_id FROM authorizations WHERE role_id=':roleId' AND action_id=':actionId'"
        );

        query.setParameter("roleId", roleId.value());
        query.setParameter("actionId", actionId.value());

        List<Object[]> results = query.list();

        sessionFactory.getCurrentSession().clear();

        return results.stream().findFirst().map(objects -> new Authorization(
            new RoleId((String) objects[0]),
            new ActionId((String) objects[1])
        ));
    }
}
