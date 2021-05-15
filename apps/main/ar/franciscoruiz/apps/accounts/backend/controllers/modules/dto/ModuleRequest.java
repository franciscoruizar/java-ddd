package ar.franciscoruiz.apps.accounts.backend.controllers.modules.dto;

public final class ModuleRequest {
    private String id;
    private String endpoint;

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String endpoint() {
        return endpoint;
    }

    public void setModule(String endpoint) {
        this.endpoint = endpoint;
    }
}
