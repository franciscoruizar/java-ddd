package ar.franciscoruiz.accounts.roles;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RolesModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected RoleRepository repository;
}
