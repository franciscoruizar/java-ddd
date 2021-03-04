package ar.franciscoruiz.shared.domain.auth;

import java.util.List;
import java.util.Objects;

public final class Authorities {
    private final List<String> values;

    public Authorities(List<String> values) {
        this.values = values;
    }

    public List<String> values() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Authorities) obj;
        return Objects.equals(this.values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Authorities[" +
            "values=" + values + ']';
    }
}
