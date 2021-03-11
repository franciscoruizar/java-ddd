package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.update.UpdateUserCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.users.dto.UserRequest;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserPutController extends ApiController {
    public UserPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> index(
        @RequestParam String id,
        @RequestBody UserRequest request
    ) {
        this.dispatch(new UpdateUserCommand(
            id,
            request.name(),
            request.lastname(),
            request.username(),
            request.email(),
            request.profilePhotoUrl(),
            request.phone(),
            request.roleId()
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
