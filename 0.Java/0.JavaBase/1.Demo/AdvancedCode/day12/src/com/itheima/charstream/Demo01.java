package com.itheima.charstream;

import java.io.FileWriter;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 创建字符流
        FileWriter fw = new FileWriter("a.txt");

        // 一次写一个字符
        fw.write(99);

        // 一次写一个字符数组
        char[] chars = {97, 98, 99, 100, 101};
        fw.write(chars);

        // 一次写一个字符数组的一部分
        fw.write(chars, 0, 3);

        // 一次写一个字符串
        String line = "黑马123";
        fw.write(line);

        // 一次写一个字符串的一部分
        fw.write(line, 0, 2);

        // 关流
        fw.close();
    }
}
