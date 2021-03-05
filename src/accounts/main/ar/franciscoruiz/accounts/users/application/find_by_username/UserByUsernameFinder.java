package ar.franciscoruiz.accounts.users.application.find_by_username;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.domain.UserDomainFinder;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.accounts.users.domain.UserUsername;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserByUsernameFinder {
    private final UserDomainFinder finder;

    public UserByUsernameFinder(UserRepository repository) {
        this.finder = new UserDomainFinder(repository);
    }

    public UserResponse find(UserUsername username) {
        return UserResponse.fromAggregate(this.finder.find(username));
    }
}
