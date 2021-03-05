package ar.franciscoruiz.accounts.actions.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateActionCommand implements Command {
    private final String id;
    private final String name;
    private final String moduleId;

    public CreateActionCommand(String id, String name, String moduleId) {
        this.id       = id;
        this.name     = name;
        this.moduleId = moduleId;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String moduleId() {
        return moduleId;
    }
}
