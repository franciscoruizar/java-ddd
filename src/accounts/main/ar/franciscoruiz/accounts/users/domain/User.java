package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleId;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public User(
        UserId id,
        UserName name,
        UserLastname lastname,
        UserUsername username,
        UserEmail email,
        UserPassword password,
        UserProfilePhotoUrl profilePhotoUrl,
        UserPhone phone,
        RoleId roleId,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        LocalDateTime deletedDate
    ) {
        this.id              = id;
        this.name            = name;
        this.lastname        = lastname;
        this.username        = username;
        this.email           = email;
        this.password        = password;
        this.profilePhotoUrl = profilePhotoUrl;
        this.phone           = phone;
        this.roleId          = roleId;
        this.createdDate     = createdDate;
        this.updatedDate     = updatedDate;
        this.deletedDate     = deletedDate;
    }

    private User() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname) && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(profilePhotoUrl, user.profilePhotoUrl) && Objects.equals(phone, user.phone) && Objects.equals(roleId, user.roleId) && Objects.equals(createdDate, user.createdDate) && Objects.equals(updatedDate, user.updatedDate) && Objects.equals(deletedDate, user.deletedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, username, email, password, profilePhotoUrl, phone, roleId, createdDate, updatedDate, deletedDate);
    }
}
