package com.sky.test.net;

import com.sky.test.io.FileDemo1;
import com.sky.test.log.MyLogger;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class NetDemo1 {
    private static final Logger logger = MyLogger.getLogger();

    public static void main(String[] args) throws IOException {
//        URL url = new URL("https://www.baidu.com");
        URL url = new URL("http://localhost:8080/TomcatDemo/demo1");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-agent", "cs go go go");

        int read;
        InputStream stream = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder();

        // 使用字节流
//        byte[] buffer = new byte[1024];
//        while ( (read=stream.read(buffer)) != -1){
//            stringBuilder.append(new String(buffer, 0, read, "UTF-8"));
//        }

        // 使用字符流
        int ct = 1;
        char[] charBuffer = new char[1024];
        while ( (read=reader.read(charBuffer)) != -1){
            stringBuilder.append(new String(charBuffer, 0, read));
            logger.debug("out:{}", ct++);
        }

        stream.close();
        FileDemo1.writeFile("./out.html", stringBuilder.toString());
    }
}
