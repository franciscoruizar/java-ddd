package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@AllArgsConstructor
@EqualsAndHashCode
public final class User {
    private final UserId              id;
    private final UserName            name;
    private final UserLastname        lastname;
    private final UserUsername        username;
    private final UserEmail           email;
    private final UserPassword        password;
    private final UserProfilePhotoUrl profilePhotoUrl;
    private final UserPhone           phone;
    private final RoleId              roleId;
    private final LocalDateTime       createdDate;
    private final LocalDateTime       updatedDate;
    private final LocalDateTime       deletedDate;

    public User() {
        this.id              = null;
        this.name            = null;
        this.lastname        = null;
        this.username        = null;
        this.email           = null;
        this.password        = null;
        this.profilePhotoUrl = null;
        this.phone           = null;
        this.roleId          = null;
        this.createdDate     = null;
        this.updatedDate     = null;
        this.deletedDate     = null;
    }

    public UserId id() {
        return id;
    }

    public UserName name() {
        return name;
    }

    public UserLastname lastname() {
        return lastname;
    }

    public UserUsername username() {
        return username;
    }

    public UserEmail email() {
        return email;
    }

    public UserPassword password() {
        return password;
    }

    public UserProfilePhotoUrl profilePhotoUrl() {
        return profilePhotoUrl;
    }

    public UserPhone phone() {
        return phone;
    }

    public RoleId roleId() {
        return roleId;
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
}
