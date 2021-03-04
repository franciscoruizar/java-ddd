package ar.franciscoruiz.accounts.users.application.search_by_criteria;

import ar.franciscoruiz.accounts.users.application.UsersResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchUserByCriteriaQueryHandler implements QueryHandler<SearchUserByCriteriaQuery, UsersResponse> {
    private final UsersByCriteriaSearcher searcher;

    public SearchUserByCriteriaQueryHandler(UsersByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public UsersResponse handle(SearchUserByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
