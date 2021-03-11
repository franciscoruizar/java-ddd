package ar.franciscoruiz.accounts.authorizations.application.search_by_role;

import ar.franciscoruiz.accounts.authorizations.application.AuthorizationsResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAuthorizationsByRoleIdQueryHandler implements QueryHandler<SearchAuthorizationsByRoleIdQuery, AuthorizationsResponse> {
    private final AuthorizationsByRoleIdSearcher searcher;

    public SearchAuthorizationsByRoleIdQueryHandler(AuthorizationsByRoleIdSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public AuthorizationsResponse handle(SearchAuthorizationsByRoleIdQuery query) {
        RoleId roleId = new RoleId(query.roleId());

        return searcher.search(roleId);
    }
}
