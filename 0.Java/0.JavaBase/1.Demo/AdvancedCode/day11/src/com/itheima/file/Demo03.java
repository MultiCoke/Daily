package com.itheima.file;

import java.io.File;
import java.io.IOException;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        // 判断file是否为目录
        File file1 = new File("a.txt");
        file1.createNewFile();
        System.out.println(file1.isDirectory());

        // 判断file是否为文件
        System.out.println(file1.isFile());

        // 判断file是否存在
        System.out.println(file1.exists());

        // 返回file文件名
        System.out.println(file1.getName());
    }
}
