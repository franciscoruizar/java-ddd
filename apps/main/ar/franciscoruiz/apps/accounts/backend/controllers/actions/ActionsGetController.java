package ar.franciscoruiz.apps.accounts.backend.controllers.actions;

import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.actions.application.search_by_criteria.SearchActionsByCriteriaQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
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
    public List<HashMap<String, Serializable>> index(@RequestParam HashMap<String, Serializable> params) throws QueryHandlerExecutionError {
        ActionsResponse actions = ask(
            new SearchActionsByCriteriaQuery(
                parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
            )
        );

        return actions.values().stream().map(action -> new HashMap<String, Serializable>() {{
                put("id", action.id());
                put("name", action.name());
                put("module_id", action.moduleId());
            }}
        ).collect(Collectors.toList());
    }
}
