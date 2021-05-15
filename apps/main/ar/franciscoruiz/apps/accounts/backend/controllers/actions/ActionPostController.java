package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.actions.application.create.CreateActionCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.actions.dto.ActionRequest;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ActionPostController extends ApiController {
    public ActionPostController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/actions/{id}")
    public ResponseEntity<String> index(
        @RequestBody ActionRequest request
    ) {
        if (request.id() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        this.dispatch(new CreateActionCommand(request.id(), request.method(), request.moduleId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
