package ar.franciscoruiz.accounts.roles.application.search_all;

import ar.franciscoruiz.accounts.roles.application.RoleResponse;
import ar.franciscoruiz.accounts.roles.application.RolesResponse;
import ar.franciscoruiz.accounts.roles.domain.RoleRepository;
import ar.franciscoruiz.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class AllRolesSearcher {
    private final RoleRepository repository;

    public AllRolesSearcher(RoleRepository repository) {
        this.repository = repository;
    }

    public RolesResponse search() {
        return new RolesResponse(
            repository.searchAll()
                .stream()
                .map(RoleResponse::fromAggregate)
                .collect(Collectors.toList())
        );
    }
}
