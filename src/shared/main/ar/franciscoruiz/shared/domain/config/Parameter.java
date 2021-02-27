package ar.franciscoruiz.shared.domain.config;

public interface Parameter {
    String get(String parameter) throws ParameterNotExist;

    Integer getInt(String parameter) throws ParameterNotExist;
}
