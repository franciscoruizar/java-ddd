package ar.franciscoruiz.accounts.modules.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateModuleCommand implements Command {
    private final String id;
    private final String name;

    public CreateModuleCommand(String id, String name) {
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
