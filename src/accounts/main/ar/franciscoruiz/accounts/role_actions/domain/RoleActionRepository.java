package ar.franciscoruiz.accounts.role_actions.domain;

import ar.franciscoruiz.accounts.actions.domain.ActionId;
import ar.franciscoruiz.accounts.roles.domain.RoleId;

import java.util.List;
import java.util.Optional;

public interface RoleActionRepository {
    void save(RoleAction roleAction);

    List<RoleAction> searchByRoleId(RoleId roleId);

    Optional<RoleAction> find(RoleId roleId, ActionId actionId);
}
