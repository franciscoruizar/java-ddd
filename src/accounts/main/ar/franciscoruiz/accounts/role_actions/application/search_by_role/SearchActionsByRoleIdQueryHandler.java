package ar.franciscoruiz.accounts.role_actions.application.search_by_role;

import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchActionsByRoleIdQueryHandler implements QueryHandler<SearchActionsByRoleIdQuery, ActionsResponse> {
    private final ActionsByRoleIdSearcher searcher;

    public SearchActionsByRoleIdQueryHandler(ActionsByRoleIdSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public ActionsResponse handle(SearchActionsByRoleIdQuery query) {
        RoleId roleId = new RoleId(query.roleId());

        return searcher.search(roleId);
    }
}
