package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.accounts.modules.application.ModulesResponse;
import ar.franciscoruiz.accounts.modules.application.search_by_criteria.SearchModulesByCriteriaQuery;
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
public final class ModulesGetController extends ApiController {
    public ModulesGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/modules")
    public List<HashMap<String, Object>> index(@RequestParam HashMap<String, Serializable> params) throws QueryHandlerExecutionError {
        ModulesResponse modules = ask(
            new SearchModulesByCriteriaQuery(
                parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
            )
        );

        return modules.values().stream().map(this::encode).collect(Collectors.toList());
    }
}
