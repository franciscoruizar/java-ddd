package ar.franciscoruiz.accounts.role_actions.infrastructure.persistence;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.role_actions.domain.RoleAction;
import ar.franciscoruiz.accounts.role_actions.domain.RoleActionRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class HibernateRoleActionRepository extends HibernateRepository<RoleAction> implements RoleActionRepository {
    public HibernateRoleActionRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, RoleAction.class);
    }

    @Override
    public void save(RoleAction roleAction) {
        NativeQuery query = sessionFactory.getCurrentSession().createNativeQuery(
            "INSERT INTO role_actions (role_id, action_id) VALUES (:roleId, :actionId);"
        );

        query.setParameter("roleId", roleAction.roleId().value())
            .setParameter("actionId", roleAction.actionId().value());

        query.executeUpdate();
    }

    @Override
    public List<RoleAction> searchByRoleId(RoleId roleId) {
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(
            "SELECT role_id, action_id FROM role_actions WHERE role_id=':roleId'"
        );

        query.setParameter("roleId", roleId.value());

        List<Object[]> results = query.list();

        sessionFactory.getCurrentSession().clear();

        return results.stream().map(objects -> new RoleAction(
            new RoleId((String) objects[0]),
            new ActionId((String) objects[1])
        )).collect(Collectors.toList());
    }

    @Override
    public Optional<RoleAction> find(RoleId roleId, ActionId actionId) {
        NativeQuery query = sessionFactory.getCurrentSession().createSQLQuery(
            "SELECT role_id, action_id FROM role_actions WHERE role_id=':roleId' AND action_id=':actionId'"
        );

        query.setParameter("roleId", roleId.value());
        query.setParameter("actionId", actionId.value());

        List<Object[]> results = query.list();

        sessionFactory.getCurrentSession().clear();

        return results.stream().findFirst().map(objects -> new RoleAction(
            new RoleId((String) objects[0]),
            new ActionId((String) objects[1])
        ));
    }
}
