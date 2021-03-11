package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class RoleNotExist extends DomainError {
    public RoleNotExist(RoleId roleId) {
        super("role_not_exists", String.format("the role <%s> not exists", roleId.value()));
    }
}
