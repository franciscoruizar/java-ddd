package ar.franciscoruiz.accounts.actions.application.create;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.actions.domain.ActionMethod;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateActionCommandHandler implements CommandHandler<CreateActionCommand> {
    private final ActionCreator creator;

    public CreateActionCommandHandler(ActionCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateActionCommand command) {
        ActionId     id       = new ActionId(command.id());
        ActionMethod method   = new ActionMethod(command.method());
        ModuleId     moduleId = new ModuleId(command.moduleId());

        this.creator.create(id, method, moduleId);
    }
}
