package com.itheima.file;

import java.io.File;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        // 1.创建新文件
        File file1 = new File("a.txt");
        System.out.println(file1.createNewFile());

        // 2.创建单击文件夹
        File file2 = new File("day11/aaa");
        System.out.println(file2.mkdir());

        // 3.创建多级文件夹
        File file3 = new File("day11/aaa/bbb/ccc");
        System.out.println(file3.mkdirs());

    }
}
