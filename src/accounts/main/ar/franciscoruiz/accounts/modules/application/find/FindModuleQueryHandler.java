package ar.franciscoruiz.accounts.modules.application.find;

import ar.franciscoruiz.accounts.modules.application.ModuleResponse;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindModuleQueryHandler implements QueryHandler<FindModuleQuery, ModuleResponse> {
    private final ModuleFinder finder;

    public FindModuleQueryHandler(ModuleFinder finder) {
        this.finder = finder;
    }

    @Override
    public ModuleResponse handle(FindModuleQuery query) {
        ModuleId id = new ModuleId(query.id());

        return this.finder.find(id);
    }
}
