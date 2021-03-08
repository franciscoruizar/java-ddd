package ar.franciscoruiz.accounts.role_actions.application;

import java.util.List;

public final class RoleActionResponse {
    private final List<String> methods;
    private final String       endpoint;

    public RoleActionResponse(List<String> methods, String endpoint) {
        this.methods  = methods;
        this.endpoint = endpoint;
    }

    public List<String> methods() {
        return methods;
    }

    public String endpoint() {
        return endpoint;
    }
}
