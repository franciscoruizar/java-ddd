package ar.franciscoruiz.accounts.authorizations.application;

import java.util.List;

public final class AuthorizationResponse {
    private final List<String> methods;
    private final String       module;

    public AuthorizationResponse(List<String> methods, String module) {
        this.methods = methods;
        this.module  = module;
    }

    public List<String> methods() {
        return methods;
    }

    public String module() {
        return module;
    }
}
