package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.role_actions.application.search_by_role.SearchActionsByRoleIdQuery;
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

import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class ActionsByRoleGetController extends ApiController {
    public ActionsByRoleGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/roles/actions/{id}")
    public ResponseEntity<List<Response>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        ActionsResponse response = ask(new SearchActionsByRoleIdQuery(id));

        return ResponseEntity.ok().body(response.values().stream().map(Response::parse).collect(Collectors.toList()));
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Response {
        private String id;
        private String name;
        private String moduleId;

        public Response(String id, String name, String moduleId) {
            this.id       = id;
            this.name     = name;
            this.moduleId = moduleId;
        }

        public static Response parse(ActionResponse action) {
            return new Response(
                action.id(),
                action.name(),
                action.moduleId()
            );
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

        public String moduleId() {
            return moduleId;
        }

        public void setModuleId(String moduleId) {
            this.moduleId = moduleId;
        }
    }
}
