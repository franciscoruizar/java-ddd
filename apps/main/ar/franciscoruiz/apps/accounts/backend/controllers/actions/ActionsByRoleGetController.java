package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.role_actions.application.RoleActionsResponse;
import ar.franciscoruiz.accounts.role_actions.application.search_by_role.SearchActionsByRoleIdQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class ActionsByRoleGetController extends ApiController {
    public ActionsByRoleGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/roles/{id}/actions")
    public List<HashMap<String, Object>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        RoleActionsResponse response = ask(new SearchActionsByRoleIdQuery(id));

        return response.values().stream().map(this::encode).collect(Collectors.toList());
    }

}
