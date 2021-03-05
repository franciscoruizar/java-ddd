package ar.franciscoruiz.accounts.actions;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ActionsModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected ActionRepository repository;
}
