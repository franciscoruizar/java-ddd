package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserDomainFinder {
    private final UserRepository repository;

    public UserDomainFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User find(UserId id) {
        return this.repository.findById(id)
            .orElseThrow(() -> new UserNotExist(id));
    }

    public User find(UserUsername username) {
        return this.repository.findByUsername(username)
            .orElseThrow(() -> new UserNotExist(username));
    }
}
