package ar.franciscoruiz.shared.infrastructure;


import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public final class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
