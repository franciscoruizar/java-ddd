package ar.franciscoruiz.shared.domain.auth;

import java.util.List;

public final class Authorities {
    private final List<String> values;

    public Authorities(List<String> values) {
        this.values = values;
    }

    public List<String> values() {
        return this.values;
    }
}
