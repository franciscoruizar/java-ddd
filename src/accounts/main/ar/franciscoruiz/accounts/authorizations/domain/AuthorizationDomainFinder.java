package ar.franciscoruiz.accounts.authorizations.domain;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

public class AuthorizationDomainFinder {
    private final AuthorizationRepository repository;

    public AuthorizationDomainFinder(AuthorizationRepository repository) {
        this.repository = repository;
    }

    public Authorization find(RoleId roleId, ActionId actionId) {
        return repository.find(roleId, actionId).orElseThrow(() -> new AuthorizationNotExist(roleId, actionId));
    }
}
