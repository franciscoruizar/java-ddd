package ar.franciscoruiz.accounts.role_actions.application.create;

import ar.franciscoruiz.accounts.actions.domain.ActionDomainFinder;
import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.role_actions.domain.RoleAction;
import ar.franciscoruiz.accounts.role_actions.domain.RoleActionDomainFinder;
import ar.franciscoruiz.accounts.role_actions.domain.RoleActionRepository;
import ar.franciscoruiz.accounts.roles.domain.Role;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class RoleActionCreator {
    private final RoleActionRepository   repository;
    private final ActionDomainFinder     actionFinder;
    private final RoleActionDomainFinder roleActionFinder;

    public RoleActionCreator(RoleActionRepository repository, ActionRepository actionRepository) {
        this.repository       = repository;
        this.roleActionFinder = new RoleActionDomainFinder(repository);
        this.actionFinder     = new ActionDomainFinder(actionRepository);
    }

    public void create(RoleId roleId, ActionId actionId) {
        RoleAction roleAction = new RoleAction(roleId, actionId);

        ensureExistsRole(roleId);

        ensureExitsAction(actionId);

        ensureNonExistRoleAction(roleId, actionId);

        this.repository.save(roleAction);
    }

    private void ensureNonExistRoleAction(RoleId roleId, ActionId actionId) {
    }

    private void ensureExitsAction(ActionId actionId) {
        actionFinder.find(actionId);
    }

    private void ensureExistsRole(RoleId roleId) {
        Role.valueOf(roleId);
    }
}
