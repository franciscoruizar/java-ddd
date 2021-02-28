package ar.franciscoruiz.shared.domain.vo;

import ar.franciscoruiz.shared.domain.DomainError;

import java.util.Objects;

public abstract class PhoneValueObject {
    private final String value;

    public PhoneValueObject(String value) {
        this.value = value;
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

    private void validate(String value){
        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        if (!value.matches(regex))
            throw new DomainError("phone error", String.format("the phone <%s> is not valid", value));
    }
}
