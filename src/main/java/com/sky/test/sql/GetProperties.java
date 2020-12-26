package com.sky.test.sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static Properties pro = new Properties();

    public static void setResourceFile(String fileName) throws IOException {
        InputStream stream = GetProperties.class.getResourceAsStream(fileName);
        pro.load(stream);
    }

    public static String getProperties(String key){
        return pro.getProperty(key);
    }

    public static String getProperties(String key, String defaultValue){
        return pro.getProperty(key, defaultValue);
    }
}
