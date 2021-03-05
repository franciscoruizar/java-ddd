package ar.franciscoruiz.accounts.roles.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public enum Role {
    ADMIN("f7030ab4-d20f-469b-8ee4-a1c5e27bee36"),
    USER("3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static String valueOf(RoleId roleId) {
        for (var item : Role.values()) {
            if (item.value().equals(roleId))
                return item.name();
        }

        throw new DomainError("role_not_exists", String.format("the role <%s> not exists", roleId.value()));
    }

    public static Role find(RoleId roleId) {
        for (var item : Role.values()) {
            if (item.value().equals(roleId))
                return item;
        }

        throw new DomainError("role_not_exists", String.format("the role <%s> not exists", roleId.value()));
    }

    public RoleId value() {
        return new RoleId(value);
    }
}
