package ar.franciscoruiz.apps.accounts.backend;

import ar.franciscoruiz.apps.ApplicationTestCase;
import org.springframework.transaction.annotation.Transactional;

@Transactional("accounts-transaction_manager")
public abstract class AccountsApplicationTestCase extends ApplicationTestCase {
}
