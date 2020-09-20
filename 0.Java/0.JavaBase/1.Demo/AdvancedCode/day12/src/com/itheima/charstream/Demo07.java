package com.itheima.charstream;

import java.io.*;

public class Demo07 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\HY\\Desktop\\a.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("C:\\Users\\HY\\Desktop\\b.txt"), "utf-8");

        char[] chars = new char[1024];
        int len;
        while((len = isr.read(chars)) != -1){
            osw.write(chars, 0, len);
        }

        isr.close();
        osw.close();
    }
}
