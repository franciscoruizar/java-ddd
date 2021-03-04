package ar.franciscoruiz.accounts.modules;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ModulesModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected ModuleRepository repository;
}
