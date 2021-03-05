package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.accounts.modules.application.ModuleResponse;
import ar.franciscoruiz.accounts.modules.application.ModulesResponse;
import ar.franciscoruiz.accounts.modules.application.search_by_criteria.SearchModulesByCriteriaQuery;
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
public final class ModulesGetController extends ApiController {
    public ModulesGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/api/modules")
    public List<Response> index(@RequestParam HashMap<String, Serializable> params) throws QueryHandlerExecutionError {
        ModulesResponse users = ask(
            new SearchModulesByCriteriaQuery(
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

        public Response(String id, String name) {
            this.id   = id;
            this.name = name;
        }

        public static Response parse(ModuleResponse module) {
            return new Response(module.id(), module.name());
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
    }
}
