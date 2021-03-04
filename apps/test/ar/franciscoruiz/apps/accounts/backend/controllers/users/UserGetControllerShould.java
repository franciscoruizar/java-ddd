package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.apps.accounts.backend.AccountsApplicationTestCase;
import org.junit.jupiter.api.Test;

final class UserGetControllerShould extends AccountsApplicationTestCase {
    @Test
    void find_an_existing_user() throws Exception {
        String id = "1aab45ba-3c7a-4344-8936-78466eca77fa";
        String body = "\"name\": \"John\", " +
            "\"lastname\": \"Doe\", " +
            "\"username\": \"johndoe\", " +
            "\"email\": \"johndoe@gmail.com\", " +
            "\"password\": \"1234password\", " +
            "\"profile_photo_url\": \"image.jpg\", " +
            "\"phone\": \"+01 15-9876-5432\", " +
            "\"role\": \"ADMIN\"}";

        givenThereIsAUser(id, body);

        assertResponse(String.format("/api/courses/%s", id), 200, body);
    }

    @Test
    void no_find_a_non_existing_user() throws Exception {
        String id   = "4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661";
        String body = "{\"error_code\": \"user_not_exist\", \"message\": \"The user <4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661> doesn't exist\"}";

        assertResponse(String.format("/api/users/%s", id), 404, body);
    }

    private void givenThereIsAUser(String id, String body) throws Exception {
        assertRequestWithBody("POST", String.format("/api/users/%s", id), body, 201);
    }
}
