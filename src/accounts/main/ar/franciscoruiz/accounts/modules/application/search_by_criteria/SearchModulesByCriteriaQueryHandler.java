package ar.franciscoruiz.accounts.modules.application.search_by_criteria;

import ar.franciscoruiz.accounts.modules.application.ModulesResponse;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

@Service
public final class SearchModulesByCriteriaQueryHandler implements QueryHandler<SearchModulesByCriteriaQuery, ModulesResponse> {
    private final ModulesByCriteriaSearcher searcher;

    public SearchModulesByCriteriaQueryHandler(ModulesByCriteriaSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public ModulesResponse handle(SearchModulesByCriteriaQuery query) {
        Filters filters = Filters.fromValues(query.filters());
        Order   order   = Order.fromValues(query.orderBy(), query.orderType());

        return searcher.search(filters, order, query.limit(), query.offset());
    }
}
