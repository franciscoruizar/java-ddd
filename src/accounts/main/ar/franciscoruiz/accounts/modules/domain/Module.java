package ar.franciscoruiz.accounts.modules.domain;

import java.util.Objects;

public final class Module {
    private final ModuleId       id;
    private final ModuleEndpoint endpoint;

    public Module() {
        this.id       = null;
        this.endpoint = null;
    }

    public Module(ModuleId id, ModuleEndpoint endpoint) {
        this.id       = id;
        this.endpoint = endpoint;
    }

    public ModuleId id() {
        return id;
    }

    public ModuleEndpoint endpoint() {
        return endpoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return Objects.equals(id, module.id) && Objects.equals(endpoint, module.endpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, endpoint);
    }
}
