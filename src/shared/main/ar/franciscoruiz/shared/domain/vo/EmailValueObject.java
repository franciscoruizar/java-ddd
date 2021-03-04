package ar.franciscoruiz.shared.domain.vo;

import ar.franciscoruiz.shared.domain.DomainError;

import java.util.Objects;

public abstract class EmailValueObject {
    private final String value;

    public EmailValueObject(String value) {
        this.value = value;
        if (value != null)
            validate(value);
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailValueObject)) {
            return false;
        }
        EmailValueObject that = (EmailValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(String value) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!value.matches(regex))
            throw new DomainError("email error", String.format("the email <%s> is not valid", value));
    }
}
