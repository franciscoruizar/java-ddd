package ar.franciscoruiz.accounts.auth.application.find_by_username;

import ar.franciscoruiz.accounts.auth.domain.AuthRepository;
import ar.franciscoruiz.accounts.auth.domain.InvalidAuthUsername;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;

@Service
public final class AuthUserByUsernameFinder {
    private final AuthRepository repository;

    public AuthUserByUsernameFinder(AuthRepository repository) {
        this.repository = repository;
    }

    public AuthUser find(AuthUsername username) {
        return repository.search(username).orElseThrow(() -> new InvalidAuthUsername(username));
    }
}
