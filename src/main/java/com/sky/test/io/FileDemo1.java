package com.sky.test.io;

import java.io.*;
import java.net.URL;

public class FileDemo1 {

    public static void main(String[] args) throws IOException {
        URL url = FileDemo1.class.getResource("/demo.txt");
        String s = readFile(url.getPath());
        System.out.println(s);
    }

    /**
     * 通过字节流读取文档内容
     * @param fileName 要读取的文档路径
     * @return 文档内容
     * @throws IOException
     */
    public static String readFile(String fileName) throws IOException {
        // 建立输入流
        FileInputStream stream = new FileInputStream(fileName);
        BufferedInputStream buffered = new BufferedInputStream(stream);

        // 构建缓存
        int read;
        byte[] bs = new byte[1024];
        StringBuilder stringBuilder = new StringBuilder();

        // 读取内容
        while ((read = buffered.read(bs))!=-1){
            stringBuilder.append(new String(bs, 0, read));
        }
        buffered.close();

        return stringBuilder.toString();
    }

    /**
     *
     * @param fileName 要写出的文档路径
     * @param content 要写出的内容
     * @throws IOException
     */
    public static void writeFile(String fileName, String content) throws IOException {
        // 建立输出流
        FileOutputStream stream = new FileOutputStream(fileName);
        BufferedOutputStream buffered = new BufferedOutputStream(stream);

        // 写出内容
        buffered.write(content.getBytes(), 0, content.getBytes().length);
        buffered.flush();
        buffered.close();
    }
}
