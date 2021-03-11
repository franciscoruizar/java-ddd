package ar.franciscoruiz.accounts.authorizations.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class AuthorizationsResponse implements Response {
    private final List<AuthorizationResponse> values;

    public AuthorizationsResponse(List<AuthorizationResponse> values) {
        this.values = values;
    }

    public List<AuthorizationResponse> values() {
        return values;
    }
}
