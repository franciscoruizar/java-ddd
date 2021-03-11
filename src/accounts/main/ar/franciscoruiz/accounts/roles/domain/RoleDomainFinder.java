package ar.franciscoruiz.accounts.roles.domain;

public final class RoleDomainFinder {
    private final RoleRepository repository;

    public RoleDomainFinder(RoleRepository repository) {
        this.repository = repository;
    }

    public Role find(RoleId id) {
        return repository.findById(id).orElseThrow(() -> new RoleNotExist(id));
    }
}
