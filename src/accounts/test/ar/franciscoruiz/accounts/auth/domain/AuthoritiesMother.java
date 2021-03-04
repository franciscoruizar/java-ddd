package ar.franciscoruiz.accounts.auth.domain;

import ar.franciscoruiz.shared.domain.WordMother;
import ar.franciscoruiz.shared.domain.auth.Authorities;

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
