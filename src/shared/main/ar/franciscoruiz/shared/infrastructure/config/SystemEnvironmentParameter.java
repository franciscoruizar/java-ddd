package ar.franciscoruiz.shared.infrastructure.config;

import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;

public final class SystemEnvironmentParameter implements Parameter {
    @Override
    public String get(String parameter) throws ParameterNotExist {
        String value = System.getenv(parameter);

        if (null == value) {
            throw new ParameterNotExist(parameter);
        }

        return value;
    }

    @Override
    public Integer getInt(String parameter) throws ParameterNotExist {
        return Integer.parseInt(get(parameter));
    }
}
