package ar.franciscoruiz.accounts.users;

import ar.franciscoruiz.accounts.AccountsContextInfrastructureTestCase;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UsersModuleInfrastructureTestCase extends AccountsContextInfrastructureTestCase {
    @Autowired
    protected UserRepository repository;
}
