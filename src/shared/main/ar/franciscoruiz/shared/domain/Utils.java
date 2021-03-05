package ar.franciscoruiz.shared.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.google.common.base.CaseFormat;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public final class Utils {
    private static ObjectMapper instance() {
        return new ObjectMapper()
            .findAndRegisterModules()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .setVisibility(VisibilityChecker.Std.defaultInstance()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    public static <T> String jsonEncode(T map) {
        try {
            return instance().writeValueAsString(map);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static <T> T jsonDecode(String body, Class<T> aggregateClass) {
        try {
            return instance().readValue(body, aggregateClass);
        } catch (IOException e) {
            return null;
        }
    }

    public static HashMap<String, Serializable> jsonDecode(String body) {
        try {
            return instance().readValue(body, HashMap.class);
        } catch (IOException e) {
            return null;
        }
    }

    public static String dateToString(LocalDateTime dateTime) {
        if (null == dateTime)
            return null;
        return dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String dateToString(Timestamp timestamp) {
        if (null == timestamp)
            return null;
        return dateToString(timestamp.toLocalDateTime());
    }

    public static String toSnake(String text) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, text);
    }

    public static String toCamel(String text) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, text);
    }

    public static String toCamelFirstLower(String text) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, text);
    }

    public static String[] getGroupId() {
        String[] packages = Utils.class.getPackageName().split("\\.");
        return new String[]{packages[0], packages[1]};
    }
}
