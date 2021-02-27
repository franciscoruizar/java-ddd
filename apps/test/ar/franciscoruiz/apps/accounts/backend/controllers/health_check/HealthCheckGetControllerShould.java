package ar.franciscoruiz.apps.accounts.backend.controllers.health_check;


import ar.franciscoruiz.apps.accounts.backend.AccountsApplicationTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerShould extends AccountsApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'application':'accounts_backend','status':'ok'}");
    }
}
