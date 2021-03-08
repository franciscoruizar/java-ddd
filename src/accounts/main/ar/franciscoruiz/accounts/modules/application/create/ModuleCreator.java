package ar.franciscoruiz.accounts.modules.application.create;

import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleEndpoint;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ModuleCreator {
    private final ModuleRepository repository;

    public ModuleCreator(ModuleRepository repository) {
        this.repository = repository;
    }

    public void create(ModuleId id, ModuleEndpoint endpoint) {
        Module module = new Module(id, endpoint);

        this.repository.save(module);
    }
}
