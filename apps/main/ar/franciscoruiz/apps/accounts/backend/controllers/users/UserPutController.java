package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.application.update.UpdateUserCommand;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class UserPutController extends ApiController {
    public UserPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> index(
        @RequestParam String id,
        @RequestBody Request request
    ) {
        this.dispatch(new UpdateUserCommand(
            id,
            request.name(),
            request.lastname(),
            request.username(),
            request.email(),
            request.profilePhotoUrl(),
            request.phone(),
            Role.valueOf(request.role()).value().value()
        ));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Request {
        private String name;
        private String lastname;
        private String username;
        private String email;
        private String profilePhotoUrl;
        private String phone;
        private String role;

        public String name() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String lastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String username() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String email() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String profilePhotoUrl() {
            return profilePhotoUrl;
        }

        public void setProfilePhotoUrl(String profilePhotoUrl) {
            this.profilePhotoUrl = profilePhotoUrl;
        }

        public String phone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String role() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
