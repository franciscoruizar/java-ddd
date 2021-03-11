package ar.franciscoruiz.accounts.roles.application.search_all;

import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class SearchAllRolesQueryHandler implements QueryHandler<SearchAllRolesQuery, RolesResponse> {
    private final AllRolesSearcher searcher;

    public SearchAllRolesQueryHandler(AllRolesSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public RolesResponse handle(SearchAllRolesQuery query) {
        return searcher.search();
    }
}
