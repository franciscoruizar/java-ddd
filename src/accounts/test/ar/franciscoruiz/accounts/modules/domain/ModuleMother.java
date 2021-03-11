package ar.franciscoruiz.accounts.modules.domain;

public final class ModuleMother {
    public static Module create(ModuleId id, ModuleName name) {
        return new Module(id, name);
    }

    public static Module random() {
        return create(ModuleIdMother.random(), ModuleNameMother.random());
    }
}
