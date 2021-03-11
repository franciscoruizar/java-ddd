package ar.franciscoruiz.accounts.authorizations.application.search_by_role;

import ar.franciscoruiz.accounts.actions.domain.Action;
import ar.franciscoruiz.accounts.actions.domain.ActionDomainFinder;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.accounts.authorizations.application.AuthorizationResponse;
import ar.franciscoruiz.accounts.authorizations.application.AuthorizationsResponse;
import ar.franciscoruiz.accounts.authorizations.domain.Authorization;
import ar.franciscoruiz.accounts.authorizations.domain.AuthorizationRepository;
import ar.franciscoruiz.accounts.modules.domain.Module;
import ar.franciscoruiz.accounts.modules.domain.ModuleDomainFinder;
import ar.franciscoruiz.accounts.modules.domain.ModuleId;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public final class AuthorizationsByRoleIdSearcher {
    private final AuthorizationRepository repository;
    private final ActionDomainFinder      actionFinder;
    private final ModuleDomainFinder      moduleFinder;

    public AuthorizationsByRoleIdSearcher(AuthorizationRepository repository, ActionRepository actionRepository, ModuleRepository moduleRepository) {
        this.repository   = repository;
        this.actionFinder = new ActionDomainFinder(actionRepository);
        this.moduleFinder = new ModuleDomainFinder(moduleRepository);
    }

    public AuthorizationsResponse search(RoleId roleId) {
        List<Authorization> authorizations = repository.searchByRoleId(roleId);

        Map<ModuleId, AuthorizationResponse> roleActionHashMap = new HashMap<>();

        for (var item : authorizations) {
            Action action = actionFinder.find(item.actionId());
            Module module = moduleFinder.find(action.moduleId());

            AuthorizationResponse response;

            if (roleActionHashMap.containsKey(module.id())) {
                AuthorizationResponse roleAction = roleActionHashMap.get(module.id());
                roleAction.methods().add(action.method().value());

                response = roleAction;
            } else {
                response = new AuthorizationResponse(
                    new ArrayList<>() {{
                        add(action.method().value());
                    }},
                    module.name().value()
                );
            }

            roleActionHashMap.put(action.moduleId(), response);
        }

        return new AuthorizationsResponse(
            new ArrayList<>(roleActionHashMap.values())
        );
    }

}
