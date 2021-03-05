package ar.franciscoruiz.accounts.users.application;

import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.users.domain.User;
import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.time.LocalDateTime;

public final class UserResponse implements Response {
    private final String        id;
    private final String        fullname;
    private final String        username;
    private final String        email;
    private final String        profilePhotoUrl;
    private final String        phone;
    private final String        role;
    private final LocalDateTime createdDate;
    private final LocalDateTime updatedDate;
    private final LocalDateTime deletedDate;
    private final Boolean       isActive;

    private UserResponse() {
        this.id              = null;
        this.fullname        = null;
        this.username        = null;
        this.email           = null;
        this.profilePhotoUrl = null;
        this.phone           = null;
        this.role            = null;
        this.createdDate     = null;
        this.updatedDate     = null;
        this.deletedDate     = null;
        this.isActive        = null;
    }

    public UserResponse(
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

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(
            user.id().value(),
            user.name().value() + " " + user.lastname().value(),
            user.username().value(),
            user.email().value(),
            user.profilePhotoUrl().value(),
            user.phone().value(),
            Role.valueOf(user.roleId()),
            user.createdDate(),
            user.updatedDate(),
            user.deletedDate(),
            user.deletedDate() == null
        );
    }

    public String id() {
        return id;
    }

    public String fullname() {
        return fullname;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    public String profilePhotoUrl() {
        return profilePhotoUrl;
    }

    public String phone() {
        return phone;
    }

    public String role() {
        return role;
    }

    public LocalDateTime createdDate() {
        return createdDate;
    }

    public LocalDateTime updatedDate() {
        return updatedDate;
    }

    public LocalDateTime deletedDate() {
        return deletedDate;
    }

    public Boolean isActive() {
        return isActive;
    }
}
