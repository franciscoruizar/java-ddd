package ar.franciscoruiz.accounts.roles.infrastructure.persistence;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class HibernateRoleRepository extends HibernateRepository<Role> implements RoleRepository {
    public HibernateRoleRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Role.class);
    }

    @Override
    public void save(Role role) {
        persist(role);
    }

    @Override
    public Optional<Role> findById(RoleId id) {
        return byId(id);
    }

    @Override
    public List<Role> searchAll() {
        return all();
    }
}
