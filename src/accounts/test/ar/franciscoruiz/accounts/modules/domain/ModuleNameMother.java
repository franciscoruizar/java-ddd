package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class ModuleNameMother {
    public static ModuleEndpoint create(String value) {
        return new ModuleEndpoint(value);
    }

    public static ModuleEndpoint random() {
        return create(WordMother.random());
    }
}
