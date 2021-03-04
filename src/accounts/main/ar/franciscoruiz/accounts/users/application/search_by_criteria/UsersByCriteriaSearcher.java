package ar.franciscoruiz.accounts.users.application.search_by_criteria;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.application.UsersResponse;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.criteria.Criteria;
import ar.franciscoruiz.shared.domain.criteria.Filters;
import ar.franciscoruiz.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class UsersByCriteriaSearcher {
    private final UserRepository repository;

    public UsersByCriteriaSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public UsersResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new UsersResponse(
            repository.search(criteria)
                .stream()
                .map(UserResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
