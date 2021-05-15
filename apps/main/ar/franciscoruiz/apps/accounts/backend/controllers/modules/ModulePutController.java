package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.accounts.modules.application.create.CreateModuleCommand;
import ar.franciscoruiz.apps.accounts.backend.controllers.modules.dto.ModuleRequest;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ModulePutController extends ApiController {
    public ModulePutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/modules/{id}")
    public ResponseEntity<String> index(@PathVariable String id, @RequestBody ModuleRequest request) {
        this.dispatch(new CreateModuleCommand(id, request.endpoint()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
