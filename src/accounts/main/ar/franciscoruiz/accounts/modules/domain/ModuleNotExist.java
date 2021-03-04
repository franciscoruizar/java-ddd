package ar.franciscoruiz.accounts.modules.domain;

import ar.franciscoruiz.shared.domain.DomainError;

public final class ModuleNotExist extends DomainError {
    public ModuleNotExist(ModuleId id) {
        super("module_not_exist", String.format("The module <%s> doesn't exist", id.value()));
    }
}
