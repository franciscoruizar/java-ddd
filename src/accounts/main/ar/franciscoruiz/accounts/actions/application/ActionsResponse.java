package ar.franciscoruiz.accounts.actions.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class ActionsResponse implements Response {
    private final List<ActionResponse> values;

    public ActionsResponse(List<ActionResponse> values) {
        this.values = values;
    }

    public List<ActionResponse> values() {
        return values;
    }
}
