package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UsersResponse;
import ar.franciscoruiz.accounts.users.application.search_by_criteria.SearchUsersByCriteriaQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.Utils;
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
public final class UsersGetController extends ApiController {
    public UsersGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/api/users")
    public List<HashMap<String, Serializable>> index(@RequestParam HashMap<String, Serializable> params) throws QueryHandlerExecutionError {
        UsersResponse users = ask(
            new SearchUsersByCriteriaQuery(
                parseFilters(params),
                Optional.ofNullable((String) params.get("order_by")),
                Optional.ofNullable((String) params.get("order")),
                Optional.ofNullable((Integer) params.get("limit")),
                Optional.ofNullable((Integer) params.get("offset"))
            )
        );

        return users.values().stream().map(user -> new HashMap<String, Serializable>() {{
            put("id", user.id());
            put("fullname", user.fullname());
            put("username", user.username());
            put("email", user.email());
            put("profile_photo_url", user.profilePhotoUrl());
            put("phone", user.phone());
            put("role", user.role());
            put("created_date", Utils.dateToString(user.createdDate()));
            put("updated_date", Utils.dateToString(user.updatedDate()));
            put("deleted_date", Utils.dateToString(user.deletedDate()));
            put("is_active", user.isActive());
        }}).collect(Collectors.toList());
    }
}
