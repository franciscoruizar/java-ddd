package ar.franciscoruiz.accounts.roles.domain;

import java.util.List;
import java.util.Optional;

public interface RoleRepository {
    void save(Role role);

    Optional<Role> findById(RoleId id);

    List<Role> searchAll();
}
