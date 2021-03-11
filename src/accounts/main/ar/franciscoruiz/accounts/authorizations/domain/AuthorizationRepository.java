package ar.franciscoruiz.accounts.authorizations.domain;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

import java.util.List;
import java.util.Optional;

public interface AuthorizationRepository {
    void save(Authorization authorization);

    List<Authorization> searchByRoleId(RoleId roleId);

    Optional<Authorization> find(RoleId roleId, ActionId actionId);
}
