package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.auth.AuthUser;
import ar.franciscoruiz.shared.domain.auth.AuthUsername;

import java.util.Optional;

public interface AuthRepository {
    Optional<AuthUser> search(AuthUsername username);
}
