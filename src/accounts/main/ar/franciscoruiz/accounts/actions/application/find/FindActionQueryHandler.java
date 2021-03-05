package ar.franciscoruiz.accounts.actions.application.find;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindActionQueryHandler implements QueryHandler<FindActionQuery, ActionResponse> {
    private final ActionFinder finder;

    public FindActionQueryHandler(ActionFinder finder) {
        this.finder = finder;
    }

    @Override
    public ActionResponse handle(FindActionQuery query) {
        ActionId id = new ActionId(query.id());

        return this.finder.find(id);
    }
}
