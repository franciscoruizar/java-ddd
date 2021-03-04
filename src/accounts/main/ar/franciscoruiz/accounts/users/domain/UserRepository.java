package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    List<User> search(Criteria criteria);

    Optional<User> findByEmail(UserEmail email);

    Optional<User> findByUsername(UserUsername username);

    Optional<User> findById(UserId id);
}
