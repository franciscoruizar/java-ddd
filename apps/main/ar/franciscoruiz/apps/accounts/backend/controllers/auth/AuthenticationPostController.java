package ar.franciscoruiz.apps.accounts.backend.controllers.auth;

import ar.franciscoruiz.accounts.authentications.application.authenticate.AuthenticateUserCommand;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find_by_username.FindUserByUsernameQuery;
import ar.franciscoruiz.apps.accounts.backend.controllers.auth.dto.AuthRequest;
import ar.franciscoruiz.apps.accounts.backend.controllers.auth.dto.AuthResponse;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.apps.shared.utils.JwtUtil;
import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.applications.Application;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public final class AuthenticationPostController extends ApiController {
    private final JwtUtil jwtUtil;

    public AuthenticationPostController(QueryBus queryBus, CommandBus commandBus, JwtUtil jwtUtil) {
        super(queryBus, commandBus);
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/auth")
    public AuthResponse index(
        @RequestBody AuthRequest request,
        @RequestHeader("Application") String applicationValue
    ) throws CommandHandlerExecutionError {
        Optional<Application> application = Application.findByValue(applicationValue);

        if (Application.findByValue(applicationValue).isEmpty())
            throw new DomainError("application_error", String.format("the application <%s> not exists", applicationValue));

        dispatch(new AuthenticateUserCommand(request.username(), request.password()));

        UserResponse user = ask(new FindUserByUsernameQuery(request.username()));

        String jwt = jwtUtil.generateToken(user, application.get());

        return new AuthResponse(jwt);
    }
}


