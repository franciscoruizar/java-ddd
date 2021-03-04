package ar.franciscoruiz.accounts.modules.domain;

import java.util.Objects;

public final class Module {
    private final ModuleId   id;
    private final ModuleName name;

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
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Module) obj;
        return Objects.equals(this.id, that.id) &&
            Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Module[" +
            "id=" + id + ", " +
            "name=" + name + ']';
    }
}
