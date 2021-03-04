package ar.franciscoruiz.accounts.modules.application.find;

import ar.franciscoruiz.accounts.modules.application.ModuleResponse;
import ar.franciscoruiz.accounts.modules.domain.ModuleDomainFinder;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ModuleFinder {
    private final ModuleDomainFinder finder;

    public ModuleFinder(ModuleRepository repository) {
        this.finder = new ModuleDomainFinder(repository);
    }

    public ModuleResponse find(ModuleId id) {
        return ModuleResponse.fromAggregate(this.finder.find(id));
    }
}
