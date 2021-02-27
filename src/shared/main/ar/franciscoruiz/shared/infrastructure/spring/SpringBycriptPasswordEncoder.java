package ar.franciscoruiz.shared.infrastructure.spring;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.encoder.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public final class SpringBycriptPasswordEncoder implements PasswordEncoder {

    private final BCryptPasswordEncoder encoder;

    public SpringBycriptPasswordEncoder() {
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return this.encoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.encoder.matches(rawPassword, encodedPassword);
    }
}
