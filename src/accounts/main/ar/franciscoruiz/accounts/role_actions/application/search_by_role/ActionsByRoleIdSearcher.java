package ar.franciscoruiz.accounts.role_actions.application.search_by_role;

import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionDomainFinder;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleDomainFinder;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.accounts.role_actions.application.RoleActionResponse;
import ar.franciscoruiz.accounts.role_actions.application.RoleActionsResponse;
import ar.franciscoruiz.accounts.role_actions.domain.RoleAction;
import ar.franciscoruiz.accounts.role_actions.domain.RoleActionRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public final class ActionsByRoleIdSearcher {
    private final RoleActionRepository repository;
    private final ActionDomainFinder   actionFinder;
    private final ModuleDomainFinder   moduleFinder;

    public ActionsByRoleIdSearcher(RoleActionRepository repository, ActionRepository actionRepository, ModuleRepository moduleRepository) {
        this.repository   = repository;
        this.actionFinder = new ActionDomainFinder(actionRepository);
        this.moduleFinder = new ModuleDomainFinder(moduleRepository);
    }

    public RoleActionsResponse search(RoleId roleId) {
        List<RoleAction> roleActions = repository.searchByRoleId(roleId);

        Map<ModuleId, RoleActionResponse> roleActionHashMap = new HashMap<>();

        for (var item : roleActions) {
            Action action = actionFinder.find(item.actionId());
            Module module = moduleFinder.find(action.moduleId());

            RoleActionResponse response;

            if (roleActionHashMap.containsKey(module.id())) {
                RoleActionResponse roleAction = roleActionHashMap.get(module.id());
                roleAction.methods().add(action.method().value());

                response = roleAction;
            } else {
                response = new RoleActionResponse(
                    new ArrayList<>() {{
                        add(action.method().value());
                    }},
                    module.endpoint().value()
                );
            }

            roleActionHashMap.put(action.moduleId(), response);
        }

        return new RoleActionsResponse(
            new ArrayList<>(roleActionHashMap.values())
        );
    }

}
