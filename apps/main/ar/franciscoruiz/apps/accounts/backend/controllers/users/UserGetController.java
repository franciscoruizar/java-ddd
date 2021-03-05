package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find.FindUserQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.Utils;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class UserGetController extends ApiController {
    public UserGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/users/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        UserResponse user = ask(new FindUserQuery(id));

        return ResponseEntity.ok().body(
            new HashMap<String, Serializable>() {{
                put("id", user.id());
                put("fullname", user.fullname());
                put("username", user.username());
                put("email", user.email());
                put("profile_photo_url", user.profilePhotoUrl());
                put("phone", user.phone());
                put("role", user.role());
                put("created_date", Utils.dateToString(user.createdDate()));
                put("updated_date", Utils.dateToString(user.updatedDate()));
                put("deleted_date", Utils.dateToString(user.deletedDate()));
                put("is_active", user.isActive());
            }}
        );
    }
}
