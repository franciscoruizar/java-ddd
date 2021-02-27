package ar.franciscoruiz.shared.infrastructure.config;

import ar.franciscoruiz.shared.domain.config.Parameter;
import ar.franciscoruiz.shared.domain.config.ParameterNotExist;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class PropertiesParameter implements Parameter {
    private final Properties properties;

    public PropertiesParameter(Properties properties) throws IOException {
        this.properties = properties;

        properties.load(new FileInputStream("classpath://env.properties"));
    }

    @Override
    public String get(String parameter) throws ParameterNotExist {
        String value = properties.getProperty(parameter);

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
