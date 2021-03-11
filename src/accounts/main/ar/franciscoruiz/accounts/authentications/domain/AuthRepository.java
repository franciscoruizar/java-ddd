package ar.franciscoruiz.accounts.authentications.domain;

import java.util.Optional;

public interface AuthRepository {
    Optional<AuthUser> search(AuthUsername username);
}
