package com.sky.test.sys;

import java.util.Map;

public class SystemDemo1 {

    public static void main(String[] args) {
        Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> m: map.entrySet()) {
            System.out.printf("{key:%s, value:%s}\n", m.getKey(), m.getValue());
        }

        String java_home = System.getenv("JAVA_HOME");
        System.out.println(java_home);
    }
}
