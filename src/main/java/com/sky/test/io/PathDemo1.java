package com.sky.test.io;

import java.io.File;
import java.io.IOException;

public class PathDemo1 {

    public static void main(String[] args) throws IOException {
        String s = "C:\\Users\\skywalker\\Desktop\\pathdemo.txt";
        File file = new File(s);

        System.out.println(file);
        System.out.printf("length:%d\n", file.length());
        System.out.printf("URI:%s\n", file.toURI());
        System.out.printf("exists:%s\n", file.exists());
        System.out.printf("isDirectory:%s\n", file.isDirectory());

        if(!file.exists()){
            System.out.println("创建 pathdemo.txt");
            file.createNewFile();
        }
    }
}
