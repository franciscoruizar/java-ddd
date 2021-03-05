package ar.franciscoruiz.accounts.modules.infrastructure.persistence;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Optional;

@Service
public final class HibernateModuleRepository extends HibernateRepository<Module> implements ModuleRepository {
    public HibernateModuleRepository(@Qualifier("accounts-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Module.class);
    }

    @Override
    public void save(Module module) {
        persist(module);
    }

    @Override
    public Optional<Module> findById(ModuleId id) {
        return byId(id);
    }

    @Override
    public List<Module> search(Criteria criteria) {
        return byCriteria(criteria);
    }
}
