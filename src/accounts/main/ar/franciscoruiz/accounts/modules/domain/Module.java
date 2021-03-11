package ar.franciscoruiz.accounts.modules.domain;

import java.util.Objects;

public final class Module {
    private final ModuleId   id;
    private final ModuleName name;

    public Module() {
        this.id   = null;
        this.name = null;
    }

    public Module(ModuleId id, ModuleName name) {
        this.id   = id;
        this.name = name;
    }

    public ModuleId id() {
        return id;
    }

    public ModuleName name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id) && Objects.equals(name, module.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
