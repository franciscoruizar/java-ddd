package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.find.FindUserQuery;
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

import java.time.LocalDateTime;

@RestController
public final class UserGetController extends ApiController {
    public UserGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/api/users/{id}")
    public ResponseEntity<Response> index(@PathVariable String id) throws QueryHandlerExecutionError {
        UserResponse response = ask(new FindUserQuery(id));

        return ResponseEntity.ok().body(Response.parse(response));
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Response {
        private String        id;
        private String        fullname;
        private String        username;
        private String        email;
        private String        profilePhotoUrl;
        private String        phone;
        private String        role;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;
        private LocalDateTime deletedDate;
        private Boolean       isActive;

        public Response(
            String id,
            String fullname,
            String username,
            String email,
            String profilePhotoUrl,
            String phone,
            String role,
            LocalDateTime createdDate,
            LocalDateTime updatedDate,
            LocalDateTime deletedDate,
            Boolean isActive
        ) {
            this.id              = id;
            this.fullname        = fullname;
            this.username        = username;
            this.email           = email;
            this.profilePhotoUrl = profilePhotoUrl;
            this.phone           = phone;
            this.role            = role;
            this.createdDate     = createdDate;
            this.updatedDate     = updatedDate;
            this.deletedDate     = deletedDate;
            this.isActive        = isActive;
        }

        public static Response parse(UserResponse user) {
            return new Response(
                user.id(),
                user.fullname(),
                user.username(),
                user.email(),
                user.profilePhotoUrl(),
                user.phone(),
                user.role(),
                user.createdDate(),
                user.updatedDate(),
                user.deletedDate(),
                user.isActive()
            );
        }

        public String id() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String fullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
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

        public LocalDateTime createdDate() {
            return createdDate;
        }

        public void setCreatedDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
        }

        public LocalDateTime updatedDate() {
            return updatedDate;
        }

        public void setUpdatedDate(LocalDateTime updatedDate) {
            this.updatedDate = updatedDate;
        }

        public LocalDateTime deletedDate() {
            return deletedDate;
        }

        public void setDeletedDate(LocalDateTime deletedDate) {
            this.deletedDate = deletedDate;
        }

        public Boolean isActive() {
            return isActive;
        }

        public void setActive(Boolean active) {
            isActive = active;
        }
    }
}
