package ar.franciscoruiz.accounts.role_actions.application.search_by_role;

import ar.franciscoruiz.accounts.role_actions.application.RoleActionsResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchActionsByRoleIdQueryHandler implements QueryHandler<SearchActionsByRoleIdQuery, RoleActionsResponse> {
    private final ActionsByRoleIdSearcher searcher;

    public SearchActionsByRoleIdQueryHandler(ActionsByRoleIdSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public RoleActionsResponse handle(SearchActionsByRoleIdQuery query) {
        RoleId roleId = new RoleId(query.roleId());

        return searcher.search(roleId);
    }
}
