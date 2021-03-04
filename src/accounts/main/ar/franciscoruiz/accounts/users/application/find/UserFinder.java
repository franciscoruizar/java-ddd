package ar.franciscoruiz.accounts.users.application.find;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.domain.UserDomainFinder;
import ar.franciscoruiz.accounts.users.domain.UserId;
import ar.franciscoruiz.accounts.users.domain.UserRepository;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserFinder {
    private final UserDomainFinder finder;

    public UserFinder(UserRepository repository) {
        this.finder = new UserDomainFinder(repository);
    }

    public UserResponse find(UserId id) {
        return UserResponse.fromAggregate(this.finder.find(id));
    }
}
