package ar.franciscoruiz.apps.accounts.backend.controllers.actions.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public final class ActionRequest {
    private String id;
    private String method;
    private String moduleId;

    public String id() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String method() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String moduleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
