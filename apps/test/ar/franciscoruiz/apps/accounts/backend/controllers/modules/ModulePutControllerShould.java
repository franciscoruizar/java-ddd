package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.apps.accounts.backend.AccountsApplicationTestCase;
import org.junit.jupiter.api.Test;

final class ModulePutControllerShould extends AccountsApplicationTestCase {
    @Test
    void should_create_a_non_exists_module() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/api/modules/1aab45ba-3c7a-4344-8936-78466eca77fa",
            "{\"name\": \"Users\"}",
            201

        );
    }
}
