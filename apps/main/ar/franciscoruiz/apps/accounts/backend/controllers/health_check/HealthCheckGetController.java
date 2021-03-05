package ar.franciscoruiz.apps.accounts.backend.controllers.health_check;

import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class HealthCheckGetController extends ApiController {
    public HealthCheckGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping("/api/health-check")
    public HashMap<String, Serializable> index() {
        HashMap<String, Serializable> status = new HashMap<>();
        status.put("application", "accounts_backend");
        status.put("status", "ok");

        return status;
    }
}
