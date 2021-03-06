package ar.franciscoruiz.shared.domain.vo;

import ar.franciscoruiz.shared.domain.DomainError;

import java.util.Objects;

public abstract class PhoneValueObject {
    private final String value;

    public PhoneValueObject(String value) {
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
        if (!(o instanceof PhoneValueObject)) {
            return false;
        }
        PhoneValueObject that = (PhoneValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(String value) {
        String regex = "^[+]\\d{2}[ ]\\d{2}-\\d{4}-\\d{4}$";
        if (!value.matches(regex))
            throw new DomainError("phone error", String.format("the phone <%s> is not valid", value));
    }
}
