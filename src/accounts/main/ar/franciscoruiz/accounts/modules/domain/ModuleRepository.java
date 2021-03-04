package ar.franciscoruiz.accounts.modules.domain;

import java.util.Optional;

public interface ModuleRepository {
    void save(Module module);

    Optional<Module> findById(ModuleId id);
}
