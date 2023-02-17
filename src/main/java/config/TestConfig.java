package config;

import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final String PROPERTIES_FILE = "test.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            PROPERTIES.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load properties file", e);
        }
    }

    public static String getDomainUrl() {
        return PROPERTIES.getProperty("domainUrl");
    }

    public static int getDefaultTimeout() {
        return Integer.parseInt(PROPERTIES.getProperty("defaultTimeout"));
    }
}