package ar.franciscoruiz.shared.domain.vo;

import java.util.Objects;

public abstract class BooleanValueObject {
    private final Boolean value;

    public BooleanValueObject(Boolean value) {
        this.value = value;
    }

    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooleanValueObject that = (BooleanValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
