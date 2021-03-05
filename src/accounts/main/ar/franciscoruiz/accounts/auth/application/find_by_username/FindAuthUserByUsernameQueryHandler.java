package ar.franciscoruiz.accounts.auth.application.find_by_username;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;
import ar.franciscoruiz.shared.domain.bus.query.QueryHandler;

@Service
public final class FindAuthUserByUsernameQueryHandler implements QueryHandler<FindAuthUserByUsernameQuery, AuthUser> {
    private final AuthUserByUsernameFinder finder;

    public FindAuthUserByUsernameQueryHandler(AuthUserByUsernameFinder finder) {
        this.finder = finder;
    }

    @Override
    public AuthUser handle(FindAuthUserByUsernameQuery command) {
        AuthUsername username = new AuthUsername(command.username());

        return finder.find(username);
    }
}
