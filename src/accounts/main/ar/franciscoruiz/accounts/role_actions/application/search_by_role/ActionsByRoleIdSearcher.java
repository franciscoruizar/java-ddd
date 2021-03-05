package ar.franciscoruiz.accounts.role_actions.application.search_by_role;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.actions.domain.ActionDomainFinder;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.role_actions.domain.RoleActionRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class ActionsByRoleIdSearcher {
    private final RoleActionRepository repository;
    private final ActionDomainFinder   actionFinder;

    public ActionsByRoleIdSearcher(RoleActionRepository repository, ActionRepository actionRepository) {
        this.repository   = repository;
        this.actionFinder = new ActionDomainFinder(actionRepository);
    }

    public ActionsResponse search(RoleId roleId) {
        return new ActionsResponse(
            repository.searchByRoleId(roleId)
                .stream()
                .map(roleAction ->
                    ActionResponse.fromAggregate(
                        actionFinder.find(roleAction.actionId())
                    )
                ).collect(Collectors.toList())
        );
    }
}
