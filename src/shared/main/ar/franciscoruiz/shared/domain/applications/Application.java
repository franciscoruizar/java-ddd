package ar.franciscoruiz.shared.domain.applications;

import java.util.Arrays;
import java.util.Optional;

public enum Application {
    ACCOUNTS("2c66c344");

    private final String value;

    Application(String value) {
        this.value = value;
    }

    public static Optional<Application> findByValue(String value) {
        return Arrays.stream(Application.values()).filter(application -> application.value.equals(value)).findFirst();
    }

    public String value() {
        return value;
    }
}
