package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.accounts.modules.application.create.CreateModuleCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ModulePutController extends ApiController {
    public ModulePutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/api/modules/{id}")
    public ResponseEntity<String> index(
        @RequestParam String id,
        @RequestBody Request request
    ) {
        this.dispatch(new CreateModuleCommand(id, request.name()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String name;

        public String name() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
