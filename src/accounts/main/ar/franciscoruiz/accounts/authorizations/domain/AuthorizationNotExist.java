package ar.franciscoruiz.accounts.authorizations.domain;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.DomainError;

public final class AuthorizationNotExist extends DomainError {
    public AuthorizationNotExist(RoleId roleId, ActionId actionId) {
        super("role_action_not_exist", String.format("The relationship role <%s> and action <%s> doesn't exist", roleId.value(), actionId.value()));
    }
}
