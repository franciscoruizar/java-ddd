package ar.franciscoruiz.shared.domain.vo;

import ar.franciscoruiz.shared.domain.DomainError;

public abstract class PasswordValueObject extends StringValueObject {
    public PasswordValueObject(String value) {
        super(value);

        if (value != null && value.isEmpty())
            throw new DomainError("password empty", "please, complete the password");
    }
}
