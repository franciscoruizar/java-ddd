package ar.franciscoruiz.accounts.actions.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class ActionNotExist extends DomainError {
    public ActionNotExist(ActionId id) {
        super("action_not_exist", String.format("The action <%s> doesn't exist", id.value()));
    }
}
