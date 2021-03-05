package ar.franciscoruiz.accounts.actions.application.find;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.domain.ActionDomainFinder;
import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ActionFinder {
    private final ActionDomainFinder finder;

    public ActionFinder(ActionRepository repository) {
        this.finder = new ActionDomainFinder(repository);
    }

    public ActionResponse find(ActionId id) {
        return ActionResponse.fromAggregate(finder.find(id));
    }
}
