package ar.franciscoruiz.apps.accounts.backend.controllers.auth;

import ar.franciscoruiz.accounts.auth.application.authenticate.AuthenticateUserCommand;
import ar.franciscoruiz.accounts.auth.application.find_by_username.FindAuthUserByUsernameQuery;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import ar.franciscoruiz.shared.infrastructure.spring.JwtUtil;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class AuthenticationPostController extends ApiController {
    private final JwtUtil jwtUtil;

    public AuthenticationPostController(QueryBus queryBus, CommandBus commandBus, JwtUtil jwtUtil) {
        super(queryBus, commandBus);
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/api/auth")
    public HashMap<String, Serializable> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new AuthenticateUserCommand(request.username(), request.password()));

        AuthUser user = ask(new FindAuthUserByUsernameQuery(request.username()));

        String jwt = jwtUtil.generateToken(user);

        return new HashMap<>() {{
            put("jwt", jwt);
        }};
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String username;
        private String password;

        public String username() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String password() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}


