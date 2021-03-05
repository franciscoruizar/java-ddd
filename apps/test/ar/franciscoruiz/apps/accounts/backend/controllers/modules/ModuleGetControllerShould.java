package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.apps.accounts.backend.AccountsApplicationTestCase;
import org.junit.jupiter.api.Test;

final class ModuleGetControllerShould extends AccountsApplicationTestCase {
    @Test
    void find_an_existing_module() throws Exception {
        String id   = "1aab45ba-3c7a-4344-8936-78466eca77fa";
        String body = "{\"name\": \"Users\"}";

        givenThereIsAUser(id, body);

        assertResponse(String.format("/api/modules/%s", id), 200, body);
    }

    @Test
    void no_find_a_non_existing_module() throws Exception {
        String id   = "4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661";
        String body = "{\"error_code\": \"module_not_exist\", \"message\": \"The module <4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661> doesn't exist\"}";

        assertResponse(String.format("/api/modules/%s", id), 404, body);
    }

    private void givenThereIsAUser(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/api/modules/%s", id), body, 201);
    }
}
