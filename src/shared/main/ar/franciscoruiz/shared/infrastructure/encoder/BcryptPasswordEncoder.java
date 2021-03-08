package ar.franciscoruiz.shared.infrastructure.encoder;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;

@Service
public final class BcryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt());
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        try {
            return BCrypt.checkpw(rawPassword, encodedPassword);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
