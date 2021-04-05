package ar.franciscoruiz.accounts.users.application.registration;

import ar.franciscoruiz.accounts.roles.domain.RoleId;
import ar.franciscoruiz.accounts.users.domain.*;
import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.bus.event.EventBus;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;

import java.time.LocalDateTime;

@Service
public final class UserRegister {
    private final UserRepository   repository;
    private final EventBus         eventBus;
    private final UserDomainFinder finder;
    private final PasswordEncoder  encoder;

    public UserRegister(UserRepository repository, EventBus eventBus, PasswordEncoder encoder) {
        this.repository = repository;
        this.eventBus   = eventBus;
        this.finder     = new UserDomainFinder(repository);
        this.encoder    = encoder;
    }

    public void create(
        UserId id,
        UserName name,
        UserLastname lastname,
        UserUsername username,
        UserEmail email,
        UserPassword password,
        UserProfilePhotoUrl profilePhotoUrl,
        UserPhone phone,
        RoleId roleId
    ) {
        ensureNonExistsUser(id);

        ensureNonExistsUsername(username);

        UserPassword passwordEncoder = new UserPassword(encoder.encode(password.value()));

        User user = User.create(id, name, lastname, username, email, passwordEncoder, profilePhotoUrl, phone, roleId, LocalDateTime.now(), LocalDateTime.now(), null);

        repository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }

    private void ensureNonExistsUser(UserId id) {
        try {
            finder.find(id);

            throw new UserExists(id);
        } catch (UserNotExist ignored) {
        }
    }

    private void ensureNonExistsUsername(UserUsername username) {
        try {
            finder.find(username);

            throw new UserExists(username);
        } catch (UserNotExist ignored) {
        }
    }
}
