package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не найден файл config.properties в classpath");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Ошибка загрузки config.properties: " + ex.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}