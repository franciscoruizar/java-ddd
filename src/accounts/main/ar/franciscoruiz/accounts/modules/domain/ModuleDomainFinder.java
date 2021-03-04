package ar.franciscoruiz.accounts.modules.domain;

public final class ModuleDomainFinder {
    private final ModuleRepository repository;

    public ModuleDomainFinder(ModuleRepository repository) {
        this.repository = repository;
    }

    public Module find(ModuleId id) {
        return this.repository.findById(id).orElseThrow(() -> new ModuleNotExist(id));
    }
}
