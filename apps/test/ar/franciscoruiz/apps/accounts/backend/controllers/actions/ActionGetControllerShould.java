package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.apps.accounts.backend.AccountsApplicationTestCase;
import org.junit.jupiter.api.Test;

final class ActionGetControllerShould extends AccountsApplicationTestCase {
    @Test
    void find_an_existing_action() throws Exception {
        String id   = "6bbb45ba-3c7a-4344-9087-78466eca77fa";
        String body = "{\"name\": \"UPDATE\", \"action_id\": \"1aab45ba-3c7a-4344-8936-78466eca77fa\"}";

        givenThereIsAAction(id, body);

        assertResponse(String.format("/api/actions/%s", id), 200, body);
    }

    @Test
    void no_find_a_non_existing_action() throws Exception {
        String id   = "4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661";
        String body = "{\"error_code\": \"action_not_exist\", \"message\": \"The action <4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661> doesn't exist\"}";

        assertResponse(String.format("/api/actions/%s", id), 404, body);
    }

    private void givenThereIsAAction(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/api/actions/%s", id), body, 201);
    }
}
