package ar.franciscoruiz.accounts.users.application.registration;

import ar.franciscoruiz.shared.domain.bus.command.Command;

import java.util.Objects;

public final class RegisterUserCommand implements Command {
    private final String id;
    private final String name;
    private final String lastname;
    private final String username;
    private final String email;
    private final String password;
    private final String profilePhotoUrl;
    private final String phone;
    private final String roleId;

    public RegisterUserCommand(
        String id,
        String name,
        String lastname,
        String username,
        String email,
        String password,
        String profilePhotoUrl,
        String phone,
        String roleId
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
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String lastname() {
        return lastname;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    public String password() {
        return password;
    }

    public String profilePhotoUrl() {
        return profilePhotoUrl;
    }

    public String phone() {
        return phone;
    }

    public String roleId() {
        return roleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (RegisterUserCommand) obj;
        return Objects.equals(this.id, that.id) &&
            Objects.equals(this.name, that.name) &&
            Objects.equals(this.lastname, that.lastname) &&
            Objects.equals(this.username, that.username) &&
            Objects.equals(this.email, that.email) &&
            Objects.equals(this.password, that.password) &&
            Objects.equals(this.profilePhotoUrl, that.profilePhotoUrl) &&
            Objects.equals(this.phone, that.phone) &&
            Objects.equals(this.roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, username, email, password, profilePhotoUrl, phone, roleId);
    }

    @Override
    public String toString() {
        return "RegisterUserCommand[" +
            "id=" + id + ", " +
            "name=" + name + ", " +
            "lastname=" + lastname + ", " +
            "username=" + username + ", " +
            "email=" + email + ", " +
            "password=" + password + ", " +
            "profilePhotoUrl=" + profilePhotoUrl + ", " +
            "phone=" + phone + ", " +
            "roleId=" + roleId + ']';
    }
}
