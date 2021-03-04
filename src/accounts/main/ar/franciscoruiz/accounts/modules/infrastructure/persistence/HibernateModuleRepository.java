package ar.franciscoruiz.accounts.modules.infrastructure.persistence;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import java.util.Optional;

@Service
public final class HibernateModuleRepository extends HibernateRepository<Module> implements ModuleRepository {
    public HibernateModuleRepository(SessionFactory sessionFactory) {
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
}
