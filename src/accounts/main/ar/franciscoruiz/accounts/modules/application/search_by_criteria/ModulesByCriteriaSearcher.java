package ar.franciscoruiz.accounts.modules.application.search_by_criteria;

import ar.franciscoruiz.accounts.modules.application.ModuleResponse;
import ar.franciscoruiz.accounts.modules.application.ModulesResponse;
import ar.franciscoruiz.accounts.modules.domain.ModuleRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class ModulesByCriteriaSearcher {
    private final ModuleRepository repository;

    public ModulesByCriteriaSearcher(ModuleRepository repository) {
        this.repository = repository;
    }

    public ModulesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new ModulesResponse(
            repository.search(criteria)
                .stream()
                .map(ModuleResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
