package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.UuidMother;

public final class ModuleIdMother {
    public static ModuleId create(String value) {
        return new ModuleId(value);
    }

    public static ModuleId random() {
        return create(UuidMother.random());
    }
}
