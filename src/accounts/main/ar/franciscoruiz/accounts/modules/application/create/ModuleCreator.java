package ar.franciscoruiz.accounts.modules.application.create;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleName;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ModuleCreator {
    private final ModuleRepository repository;

    public ModuleCreator(ModuleRepository repository) {
        this.repository = repository;
    }

    public void create(ModuleId id, ModuleName name) {
        Module module = new Module(id, name);

        this.repository.save(module);
    }
}
