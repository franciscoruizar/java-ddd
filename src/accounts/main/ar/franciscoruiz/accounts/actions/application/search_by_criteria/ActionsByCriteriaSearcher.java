package ar.franciscoruiz.accounts.actions.application.search_by_criteria;

import ar.franciscoruiz.accounts.actions.application.ActionResponse;
import ar.franciscoruiz.accounts.actions.application.ActionsResponse;
import ar.franciscoruiz.accounts.actions.domain.ActionRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class ActionsByCriteriaSearcher {
    private final ActionRepository repository;

    public ActionsByCriteriaSearcher(ActionRepository repository) {
        this.repository = repository;
    }

    public ActionsResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new ActionsResponse(
            repository.search(criteria)
                .stream()
                .map(ActionResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
