package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.WordMother;

import java.util.ArrayList;
import java.util.List;

public final class AuthoritiesMother {
    public static Authorities create(List<String> values) {
        return new Authorities(values);
    }

    public static Authorities random() {
        return create(new ArrayList<>() {{
            add(WordMother.random());
        }});
    }
}
