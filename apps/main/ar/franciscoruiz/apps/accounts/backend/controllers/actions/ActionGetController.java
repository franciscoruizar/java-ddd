package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.application.find.FindActionQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ActionGetController extends ApiController {
    public ActionGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/actions/{id}")
    public ResponseEntity<Response> index(@PathVariable String id) throws QueryHandlerExecutionError {
        ActionResponse response = ask(new FindActionQuery(id));

        return ResponseEntity.ok().body(Response.parse(response));
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Response {
        private String id;
        private String name;
        private String actionId;

        public Response(String id, String name, String actionId) {
            this.id       = id;
            this.name     = name;
            this.actionId = actionId;
        }

        public static Response parse(ActionResponse action) {
            return new Response(action.id(), action.name(), action.moduleId());
        }

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String name() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String actionId() {
            return actionId;
        }

        public void setActionId(String actionId) {
            this.actionId = actionId;
        }
    }
}
