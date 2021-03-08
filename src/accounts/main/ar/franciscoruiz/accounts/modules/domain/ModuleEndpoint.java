package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class ModuleEndpoint extends StringValueObject {
    public ModuleEndpoint(String value) {
        super(value);
    }

    private ModuleEndpoint() {
        super(null);
    }
}
