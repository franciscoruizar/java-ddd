package ar.franciscoruiz.apps.accounts.backend.controllers.auth;

import ar.franciscoruiz.accounts.authentications.application.authenticate.AuthenticateUserCommand;
import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find_by_username.FindUserByUsernameQuery;
import ar.franciscoruiz.apps.shared.ApiController;
import ar.franciscoruiz.apps.shared.utils.JwtUtil;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandlerExecutionError;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
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

        UserResponse user = ask(new FindUserByUsernameQuery(request.username()));

        String jwt = jwtUtil.generateToken(user);

        return new HashMap<>() {{
            put("jwt", jwt);
        }};
    }

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


