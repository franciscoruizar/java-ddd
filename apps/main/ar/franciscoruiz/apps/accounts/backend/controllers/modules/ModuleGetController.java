package ar.franciscoruiz.apps.accounts.backend.controllers.modules;

import ar.franciscoruiz.accounts.modules.application.ModuleResponse;
import ar.franciscoruiz.accounts.modules.application.find.FindModuleQuery;
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

@RestController
public final class ModuleGetController extends ApiController {
    public ModuleGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/modules/{id}")
    public ResponseEntity<Response> index(@PathVariable String id) throws QueryHandlerExecutionError {
        ModuleResponse response = ask(new FindModuleQuery(id));

        return ResponseEntity.ok().body(Response.parse(response));
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Response {
        private String id;
        private String name;

        public Response(String id, String name) {
            this.id   = id;
            this.name = name;
        }

        public static Response parse(ModuleResponse user) {
            return new Response(
                user.id(),
                user.name()
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
    }
}
