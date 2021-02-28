package ar.franciscoruiz.accounts.roles.domain;

public enum Role {
    ADMIN("f7030ab4-d20f-469b-8ee4-a1c5e27bee36"),
    USER("3f321312-4efd-4e8d-a4fe-ba2d9fe9ed84");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public RoleId value() {
        return new RoleId(value);
    }
}
