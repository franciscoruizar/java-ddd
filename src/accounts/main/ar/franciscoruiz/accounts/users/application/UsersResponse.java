package ar.franciscoruiz.accounts.users.application;

import ar.franciscoruiz.shared.domain.bus.query.Response;

import java.util.List;

public final class UsersResponse implements Response {
    private final List<UserResponse> values;

    public UsersResponse(List<UserResponse> values) {
        this.values = values;
    }

    public List<UserResponse> values() {
        return values;
    }
}
