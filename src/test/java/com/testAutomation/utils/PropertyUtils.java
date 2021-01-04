package com.testAutomation.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    static Properties properties;

    public static void loadConfigPropertyFile(String propertyFileName) throws IOException {
        properties = new Properties();
        properties.load(ClassLoader.getSystemResource(propertyFileName).openStream());
    }

    public static Object getProperty(String propertyName) {
        try {
            return properties.getProperty(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
