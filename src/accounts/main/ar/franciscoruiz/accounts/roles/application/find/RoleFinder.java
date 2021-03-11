package ar.franciscoruiz.accounts.roles.application.find;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleDomainFinder;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class RoleFinder {
    private final RoleDomainFinder finder;

    public RoleFinder(RoleRepository repository) {
        this.finder = new RoleDomainFinder(repository);
    }

    public RoleResponse find(RoleId id) {
        return RoleResponse.fromAggregate(finder.find(id));
    }
}
