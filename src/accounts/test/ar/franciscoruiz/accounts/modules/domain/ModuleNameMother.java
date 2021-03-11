package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.WordMother;

public final class ModuleNameMother {
    public static ModuleName create(String value) {
        return new ModuleName(value);
    }

    public static ModuleName random() {
        return create(WordMother.random());
    }
}
