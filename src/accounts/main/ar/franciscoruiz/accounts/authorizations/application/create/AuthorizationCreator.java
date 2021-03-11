package ar.franciscoruiz.accounts.authorizations.application.create;

import ar.franciscoruiz.accounts.actions.domain.ActionDomainFinder;
import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.authorizations.domain.Authorization;
import ar.franciscoruiz.accounts.authorizations.domain.AuthorizationDomainFinder;
import ar.franciscoruiz.accounts.authorizations.domain.AuthorizationRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleDomainFinder;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class AuthorizationCreator {
    private final AuthorizationRepository   repository;
    private final ActionDomainFinder        actionFinder;
    private final AuthorizationDomainFinder roleActionFinder;
    private final RoleDomainFinder          roleFinder;

    public AuthorizationCreator(AuthorizationRepository repository, ActionRepository actionRepository, RoleRepository roleRepository) {
        this.repository       = repository;
        this.roleActionFinder = new AuthorizationDomainFinder(repository);
        this.actionFinder     = new ActionDomainFinder(actionRepository);
        this.roleFinder       = new RoleDomainFinder(roleRepository);
    }

    public void create(RoleId roleId, ActionId actionId) {
        Authorization authorization = new Authorization(roleId, actionId);

        ensureExistsRole(roleId);

        ensureExitsAction(actionId);

        ensureNonExistsRoleAction(roleId, actionId);

        this.repository.save(authorization);
    }

    private void ensureNonExistsRoleAction(RoleId roleId, ActionId actionId) {
        roleActionFinder.find(roleId, actionId);
    }

    private void ensureExitsAction(ActionId actionId) {
        actionFinder.find(actionId);
    }

    private void ensureExistsRole(RoleId roleId) {
        roleFinder.find(roleId);
    }
}
