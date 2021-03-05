package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface ModuleRepository {
    void save(Module module);

    Optional<Module> findById(ModuleId id);

    List<Module> search(Criteria criteria);
}

