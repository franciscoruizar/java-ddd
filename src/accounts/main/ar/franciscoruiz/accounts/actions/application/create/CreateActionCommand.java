package ar.franciscoruiz.accounts.actions.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateActionCommand implements Command {
    private final String id;
    private final String method;
    private final String moduleId;

    public CreateActionCommand(String id, String method, String moduleId) {
        this.id       = id;
        this.method   = method;
        this.moduleId = moduleId;
    }

    public String id() {
        return id;
    }

    public String method() {
        return method;
    }

    public String moduleId() {
        return moduleId;
    }
}
