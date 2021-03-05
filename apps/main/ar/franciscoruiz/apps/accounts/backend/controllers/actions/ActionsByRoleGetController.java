package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.role_actions.application.search_by_role.SearchActionsByRoleIdQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class ActionsByRoleGetController extends ApiController {
    public ActionsByRoleGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/roles/actions/{id}")
    public List<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        ActionsResponse actions = ask(new SearchActionsByRoleIdQuery(id));

        return actions.values().stream().map(action -> new HashMap<String, Serializable>() {{
                put("id", action.id());
                put("name", action.name());
                put("module_id", action.moduleId());
            }}
        ).collect(Collectors.toList());
    }

}
