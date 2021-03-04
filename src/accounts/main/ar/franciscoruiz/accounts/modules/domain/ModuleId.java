package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.Identifier;

public final class ModuleId extends Identifier {
    public ModuleId(String value) {
        super(value);
    }

    private ModuleId() {
        super(null);
    }
}
