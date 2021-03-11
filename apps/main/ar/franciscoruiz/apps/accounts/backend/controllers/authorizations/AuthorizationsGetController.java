package ar.franciscoruiz.apps.accounts.backend.controllers.authorizations;

import ar.franciscoruiz.accounts.authorizations.application.AuthorizationsResponse;
import ar.franciscoruiz.accounts.authorizations.application.search_by_role.SearchAuthorizationsByRoleIdQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public final class AuthorizationsGetController extends ApiController {
    public AuthorizationsGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/authorizations", params = {"role_id"})
    public List<HashMap<String, Object>> index(@RequestParam(name = "role_id") String roleId) throws QueryHandlerExecutionError {
        AuthorizationsResponse response = ask(new SearchAuthorizationsByRoleIdQuery(roleId));

        return response.values().stream().map(this::encode).collect(Collectors.toList());
    }

}
