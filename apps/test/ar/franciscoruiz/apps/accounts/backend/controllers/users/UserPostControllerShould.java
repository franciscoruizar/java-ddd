package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.apps.accounts.backend.AccountsApplicationTestCase;
import org.junit.jupiter.api.Test;

final class UserPostControllerShould extends AccountsApplicationTestCase {
    @Test
    void should_create_a_non_exists_user() throws Exception {
        assertRequestWithBody(
            "POST",
            "/api/users",
            "{\"id\": \"1aab45ba-3c7a-4344-8936-78466eca77fa\", " +
                "\"name\": \"John\", " +
                "\"lastname\": \"Doe\", " +
                "\"username\": \"johndoe\", " +
                "\"email\": \"johndoe@gmail.com\", " +
                "\"password\": \"1234password\", " +
                "\"profile_photo_url\": \"image.jpg\", " +
                "\"phone\": \"+01 15-9876-5432\", " +
                "\"role\": \"ADMIN\"}",
            201

        );
    }
}
