package ar.franciscoruiz.accounts.authentications.domain;

import ar.franciscoruiz.shared.domain.bus.query.Response;

public final class AuthUser implements Response {
    private final AuthUsername username;
    private final AuthPassword password;
    private final Authority    authority;

    public AuthUser(AuthUsername username, AuthPassword password, Authority authority) {
        this.username  = username;
        this.password  = password;
        this.authority = authority;
    }

    public AuthUsername username() {
        return username;
    }

    public AuthPassword password() {
        return password;
    }

    public Authority authority() {
        return authority;
    }
}
