package com.itheima.charstream;

import java.io.FileReader;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        // 创建字符流
        FileReader fr = new FileReader("a.txt");

        char[] chars = new char[1024];
        int len;

        while((len = fr.read(chars)) != -1){
            System.out.println(new String(chars, 0, len));
        }

        fr.close();
    }
}
