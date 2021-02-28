package ar.franciscoruiz.accounts.users.domain;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.roles.domain.RoleIdMother;

import java.time.LocalDateTime;

public final class UserMother {
    public static User create(
        UserId id,
        UserName name,
        UserLastname lastname,
        UserUsername username,
        UserEmail email,
        UserPassword password,
        UserProfilePhotoUrl profilePhotoUrl,
        UserPhone phone,
        RoleId roleId,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        LocalDateTime deletedDate
    ) {
        return new User(id, name, lastname, username, email, password, profilePhotoUrl, phone, roleId, createdDate, updatedDate, deletedDate);
    }

    public static User random() {
        return create(
            UserIdMother.random(),
            UserNameMother.random(),
            UserLastnameMother.random(),
            UserUsernameMother.random(),
            UserEmailMother.random(),
            UserPasswordMother.random(),
            UserProfilePhotoUrlMother.random(),
            UserPhoneMother.random(),
            RoleIdMother.random(),
            LocalDateTime.now(),
            LocalDateTime.now(),
            LocalDateTime.now()
        );
    }
}
