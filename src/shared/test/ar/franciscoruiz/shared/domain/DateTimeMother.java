package ar.franciscoruiz.shared.domain;

import java.time.LocalDateTime;

public final class DateTimeMother {
    public static LocalDateTime random() {
        return LocalDateTime.now();
    }
}
