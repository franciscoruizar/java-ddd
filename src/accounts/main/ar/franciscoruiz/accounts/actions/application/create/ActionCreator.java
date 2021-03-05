package ar.franciscoruiz.accounts.actions.application.create;

import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.actions.domain.ActionName;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.modules.domain.ModuleDomainFinder;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ActionCreator {
    private final ActionRepository   repository;
    private final ModuleDomainFinder moduleFinder;

    public ActionCreator(ActionRepository repository, ModuleRepository moduleRepository) {
        this.repository   = repository;
        this.moduleFinder = new ModuleDomainFinder(moduleRepository);
    }

    public void create(ActionId id, ActionName name, ModuleId moduleId) {
        Action action = new Action(id, name, moduleId);

        ensureModule(moduleId);

        this.repository.save(action);
    }

    private void ensureModule(ModuleId moduleId) {
        moduleFinder.find(moduleId);
    }
}
