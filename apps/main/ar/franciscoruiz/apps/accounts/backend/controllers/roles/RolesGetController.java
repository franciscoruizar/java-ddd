package ar.franciscoruiz.apps.accounts.backend.controllers.roles;

import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.accounts.roles.application.search_all.SearchAllRolesQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class RolesGetController extends ApiController {
    public RolesGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/roles")
    public List<HashMap<String, Object>> index() throws QueryHandlerExecutionError {

        RolesResponse responses = ask(new SearchAllRolesQuery());

        return responses.values().stream().map(this::encode).collect(Collectors.toList());
    }
}
