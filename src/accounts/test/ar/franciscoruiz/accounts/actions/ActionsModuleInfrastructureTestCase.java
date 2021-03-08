package ar.franciscoruiz.accounts.actions;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ActionsModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected ActionRepository repository;

    @Autowired
    protected ModuleRepository moduleRepository;
}
