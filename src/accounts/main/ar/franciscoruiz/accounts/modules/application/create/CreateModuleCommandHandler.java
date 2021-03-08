package ar.franciscoruiz.accounts.modules.application.create;

import ar.franciscoruiz.accounts.modules.domain.ModuleEndpoint;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateModuleCommandHandler implements CommandHandler<CreateModuleCommand> {
    private final ModuleCreator creator;

    public CreateModuleCommandHandler(ModuleCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateModuleCommand command) {
        ModuleId       id   = new ModuleId(command.id());
        ModuleEndpoint name = new ModuleEndpoint(command.endpoint());

        this.creator.create(id, name);
    }
}
