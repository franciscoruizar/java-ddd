package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.actions.application.search_by_criteria.SearchActionsByCriteriaQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class ActionsGetController extends ApiController {
    public ActionsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/api/actions")
    public List<Response> index(@RequestParam HashMap<String, Serializable> params) throws QueryHandlerExecutionError {
        ActionsResponse users = ask(
            new SearchActionsByCriteriaQuery(
                parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
            )
        );

        return users.values().stream().map(Response::parse).collect(Collectors.toList());
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
