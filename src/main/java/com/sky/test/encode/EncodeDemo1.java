package com.sky.test.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

public class EncodeDemo1 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "123一二三";

        printBytes(s.getBytes());
        printBytes(s.getBytes("UTF-8"));
        printBytes(s.getBytes("GBK"));
        printBytes(s.getBytes("UNICODE"));
    }

    static void printBytes(byte[] bytes){
        for (byte b: bytes) {
            System.out.printf("%x.", b&0xff);
        }
        System.out.print("\n");
    }

    static void printAllCharsets(){
        Map<String, Charset> set = Charset.availableCharsets();
        for ( Map.Entry<String, Charset> a : set.entrySet()){
            System.out.printf("{key:%s value:%s}\n", a.getKey(), a.getValue());
        }
    }
}
