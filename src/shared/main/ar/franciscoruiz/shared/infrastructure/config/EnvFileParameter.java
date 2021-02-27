package ar.franciscoruiz.shared.infrastructure.config;

import ar.franciscoruiz.shared.domain.Service;
import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;
import io.github.cdimascio.dotenv.Dotenv;

@Service
public final class EnvFileParameter implements Parameter {
    private final Dotenv dotenv;

    public EnvFileParameter() {
        this.dotenv = Dotenv.load();
    }

    public String get(String key) throws ParameterNotExist {
        String value = dotenv.get(key);

        if (null == value) {
            throw new ParameterNotExist(key);
        }

        return value;
    }

    public Integer getInt(String key) throws ParameterNotExist {
        String value = get(key);

        return Integer.parseInt(value);
    }
}
