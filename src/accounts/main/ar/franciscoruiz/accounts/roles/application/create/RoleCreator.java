package ar.franciscoruiz.accounts.roles.application.create;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleName;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class RoleCreator {
    private final RoleRepository repository;

    public RoleCreator(RoleRepository repository) {
        this.repository = repository;
    }

    public void create(RoleId id, RoleName name) {
        Role role = new Role(id, name);

        this.repository.save(role);
    }
}
