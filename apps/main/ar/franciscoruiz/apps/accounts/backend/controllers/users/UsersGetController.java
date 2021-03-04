package ar.franciscoruiz.apps.accounts.backend.controllers.users;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.UsersResponse;
import ar.franciscoruiz.accounts.users.application.search_by_criteria.SearchUserByCriteriaQuery;
import ar.franciscoruiz.shared.domain.bus.command.CommandBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryBus;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandlerExecutionError;
import ar.franciscoruiz.shared.infrastructure.spring.ApiController;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public final class UsersGetController extends ApiController {
    public UsersGetController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping("/api/courses")
    public List<Response> index(
        @RequestParam HashMap<String, Serializable> params
    ) throws QueryHandlerExecutionError {
        UsersResponse users = ask(
            new SearchUserByCriteriaQuery(
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
