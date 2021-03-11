package ar.franciscoruiz.apps.accounts.backend.controllers.authorizations;

import ar.franciscoruiz.accounts.authorizations.application.create.CreateAuthorizationCommand;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class AuthorizationPutController extends ApiController {
    public AuthorizationPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PostMapping("/api/authorizations")
    public ResponseEntity<String> index(
        @RequestParam Request request
    ) {
        this.dispatch(new CreateAuthorizationCommand(request.roleId(), request.actionId()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String roleId;
        private String actionId;

        public String roleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public String actionId() {
            return actionId;
        }

        public void setActionId(String actionId) {
            this.actionId = actionId;
        }
    }
}