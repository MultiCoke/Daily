package com.itheima.io;

import java.io.*;

public class Demo06 {
    public static void main(String[] args) throws IOException {
        // 底层默认8192字节缓冲区
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("b.txt"));

        int b;
        while((b = bis.read()) != -1){
            bos.write(b);
        }

        bis.close();
        bos.close();
    }
}
