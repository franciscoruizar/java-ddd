package ar.franciscoruiz.accounts.users.application.update;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;

@Service
public final class UserUpdater {
    private final UserRepository   repository;
    private final UserDomainFinder finder;

    public UserUpdater(UserRepository repository) {
        this.repository = repository;
        this.finder     = new UserDomainFinder(repository);
    }

    public void update(
        UserId id,
        UserName name,
        UserLastname lastname,
        UserUsername username,
        UserEmail email,
        UserProfilePhotoUrl profilePhotoUrl,
        UserPhone phone,
        RoleId roleId
    ) {
        User user = ensureExistsUser(id);

        ensureNonExistsUsername(username);

        User userUpdated = validateUserFields(user, id, name, lastname, username, email, profilePhotoUrl, phone, roleId);

        repository.save(userUpdated);
    }

    private User validateUserFields(User user, UserId id, UserName name, UserLastname lastname, UserUsername username, UserEmail email, UserProfilePhotoUrl profilePhotoUrl, UserPhone phone, RoleId roleId) {
        UserId              idUpdated              = !id.equals(user.id()) ? id : user.id();
        UserName            nameUpdated            = !name.equals(user.name()) ? name : user.name();
        UserLastname        lastnameUpdated        = !lastname.equals(user.lastname()) ? lastname : user.lastname();
        UserUsername        usernameUpdated        = !username.equals(user.username()) ? username : user.username();
        UserEmail           emailUpdated           = !email.equals(user.email()) ? email : user.email();
        UserProfilePhotoUrl profilePhotoUrlUpdated = !profilePhotoUrl.equals(user.profilePhotoUrl()) ? profilePhotoUrl : user.profilePhotoUrl();
        UserPhone           phoneUpdated           = !phone.equals(user.phone()) ? phone : user.phone();
        RoleId              roleIdUpdated          = !roleId.equals(user.roleId()) ? roleId : user.roleId();

        return new User(
            idUpdated,
            nameUpdated,
            lastnameUpdated,
            usernameUpdated,
            emailUpdated,
            user.password(),
            profilePhotoUrlUpdated,
            phoneUpdated,
            roleIdUpdated,
            user.createdDate(),
            user.updatedDate(),
            user.deletedDate()
        );
    }

    private User ensureExistsUser(UserId id) {
        return finder.find(id);
    }

    private void ensureNonExistsUsername(UserUsername username) {
        try {
            finder.find(username);

            throw new UserExists(username);
        } catch (UserNotExist ignored) {
        }
    }
}
