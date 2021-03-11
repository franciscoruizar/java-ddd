package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.registration.RegistrationUserCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.users.dto.UserRequest;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserPostController extends ApiController {
    public UserPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/api/users")
    public ResponseEntity<String> index(
        @RequestBody UserRequest request
    ) {
        this.dispatch(new RegistrationUserCommand(
            request.id(),
            request.name(),
            request.lastname(),
            request.username(),
            request.email(),
            request.password(),
            request.profilePhotoUrl(),
            request.phone(),
            request.roleId()
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
