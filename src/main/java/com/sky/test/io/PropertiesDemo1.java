package com.sky.test.io;

import com.sky.test.sql.GetProperties;

import java.io.IOException;

public class PropertiesDemo1 {

    public static void main(String[] args) throws IOException {
        GetProperties.setResourceFile("/druid.properties");
        System.out.println(GetProperties.getProperties("password"));
        System.out.println(GetProperties.getProperties("user", "sky"));
    }
}
