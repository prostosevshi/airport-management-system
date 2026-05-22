package com.solvd.airportmanagement.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties properties =
            new Properties();

    static {

        try (InputStream inputStream =
                     Config.class.getClassLoader()
                             .getResourceAsStream("config.properties")) {

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}