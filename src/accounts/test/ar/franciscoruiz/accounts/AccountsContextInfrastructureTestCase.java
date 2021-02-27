package ar.franciscoruiz.accounts;

import ar.franciscoruiz.apps.accounts.backend.AccountsBackendApplication;
import ar.franciscoruiz.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AccountsBackendApplication.class)
@SpringBootTest
public abstract class AccountsContextInfrastructureTestCase extends InfrastructureTestCase {
}
