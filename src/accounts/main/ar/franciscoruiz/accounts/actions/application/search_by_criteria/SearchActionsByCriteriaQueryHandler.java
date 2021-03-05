package ar.franciscoruiz.accounts.actions.application.search_by_criteria;

import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchActionsByCriteriaQueryHandler implements QueryHandler<SearchActionsByCriteriaQuery, ActionsResponse> {
    private final ActionsByCriteriaSearcher searcher;

    public SearchActionsByCriteriaQueryHandler(ActionsByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public ActionsResponse handle(SearchActionsByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
