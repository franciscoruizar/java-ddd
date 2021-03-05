package ar.franciscoruiz.accounts.users.application.find_by_username;

import ar.franciscoruiz.accounts.users.application.UserResponse;
import ar.franciscoruiz.accounts.users.domain.UserUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserByUsernameQueryHandler implements QueryHandler<FindUserByUsernameQuery, UserResponse> {
    private final UserByUsernameFinder finder;

    public FindUserByUsernameQueryHandler(UserByUsernameFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindUserByUsernameQuery query) {
        UserUsername username = new UserUsername(query.username());

        return this.finder.find(username);
    }
}
