package ar.franciscoruiz.apps.accounts.backend.controllers.authorizations;

import ar.franciscoruiz.accounts.authorizations.application.create.CreateAuthorizationCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.authorizations.dto.AuthorizationRequest;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AuthorizationPostController extends ApiController {
    public AuthorizationPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/authorizations")
    public ResponseEntity<String> index(@RequestParam AuthorizationRequest request) {
        this.dispatch(new CreateAuthorizationCommand(request.roleId(), request.actionId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
