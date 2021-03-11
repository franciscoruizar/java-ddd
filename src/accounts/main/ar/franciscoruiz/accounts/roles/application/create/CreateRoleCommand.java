package ar.franciscoruiz.accounts.roles.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateRoleCommand implements Command {
    private final String id;
    private final String name;

    public CreateRoleCommand(String id, String name) {
        this.id   = id;
        this.name = name;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }
}
