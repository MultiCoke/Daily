package com.itheima.homework;

import java.io.*;

public class Demo03 {
    /*
    使用字节流，将一个路径下的视频复制到另一路径下
     */
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\HY\\Documents\\VideoData\\JavaWeb\\JavaWeb直接入土上250p\\1.01_今日内容(1)(Av50351111,P1).mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\HY\\Documents\\VideoData\\JavaWeb\\1.01_今日内容(1)(Av50351111,P1).mp4"));

        byte[] bytes = new byte[1024];
        int len;

        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }

        bis.close();
        bos.close();

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
