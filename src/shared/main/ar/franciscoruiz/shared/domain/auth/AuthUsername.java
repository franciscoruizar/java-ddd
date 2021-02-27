package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthUsername extends StringValueObject {
    public AuthUsername(String value) throws Exception {
        super(value);

        if (value.isEmpty())
            throw new Exception("Username is empty");
    }
}
