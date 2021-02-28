package ar.franciscoruiz.shared.domain.auth;

import ar.franciscoruiz.shared.domain.DomainError;
import ar.franciscoruiz.shared.domain.vo.StringValueObject;

public final class AuthUsername extends StringValueObject {
    public AuthUsername(String value) throws DomainError {
        super(value);

        if (value.isEmpty())
            throw new DomainError("Username is empty", "please, complete the username");
    }
}
