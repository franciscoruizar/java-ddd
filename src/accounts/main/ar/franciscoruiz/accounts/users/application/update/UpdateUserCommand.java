package ar.franciscoruiz.accounts.users.application.update;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class UpdateUserCommand implements Command {
    private final String id;
    private final String name;
    private final String lastname;
    private final String username;
    private final String email;
    private final String profilePhotoUrl;
    private final String phone;
    private final String roleId;

    public UpdateUserCommand(
        String id,
        String name,
        String lastname,
        String username,
        String email,
        String profilePhotoUrl,
        String phone,
        String roleId
    ) {
        this.id              = id;
        this.name            = name;
        this.lastname        = lastname;
        this.username        = username;
        this.email           = email;
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

    public String profilePhotoUrl() {
        return profilePhotoUrl;
    }

    public String phone() {
        return phone;
    }

    public String roleId() {
        return roleId;
    }
}
