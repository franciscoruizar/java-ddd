package ar.franciscoruiz.shared.domain.vo;

import ar.franciscoruiz.shared.domain.DomainError;

import java.util.Objects;

public abstract class UrlValueObject {
    private final String value;

    public UrlValueObject(String value) {
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
        if (!(o instanceof UrlValueObject)) {
            return false;
        }
        UrlValueObject that = (UrlValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private void validate(String value) {
        String regex = "^((((http|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)([).!';/?:,][[:blank:]])?$";
        if (!value.matches(regex))
            throw new DomainError("url error", String.format("the url <%s> is not valid", value));
    }
}
