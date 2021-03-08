package ar.franciscoruiz.accounts.modules.application.create;

import ar.franciscoruiz.shared.domain.bus.command.Command;

public final class CreateModuleCommand implements Command {
    private final String id;
    private final String endpoint;

    public CreateModuleCommand(String id, String endpoint) {
        this.id       = id;
        this.endpoint = endpoint;
    }

    public String id() {
        return id;
    }

    public String endpoint() {
        return endpoint;
    }
}
