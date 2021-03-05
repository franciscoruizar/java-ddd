package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.Service;

@Service
public final class ActionDomainFinder {
    private final ActionRepository repository;

    public ActionDomainFinder(ActionRepository repository) {
        this.repository = repository;
    }

    public Action find(ActionId id) {
        return repository.findById(id).orElseThrow(() -> new ActionNotExist(id));
    }
}
