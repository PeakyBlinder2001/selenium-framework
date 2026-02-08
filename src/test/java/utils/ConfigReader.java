package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    public static void loadConfig() {
        try {
            InputStream input =
                    ConfigReader.class
                            .getClassLoader()
                            .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties NOT found in resources folder");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException("Property NOT found in config.properties: " + key);
        }
        return value;
    }
}
