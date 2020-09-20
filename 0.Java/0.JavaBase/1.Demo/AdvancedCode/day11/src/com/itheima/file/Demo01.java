package com.itheima.file;

import java.io.File;

public class Demo01 {
    public static void main(String[] args) {
        // 1.第一种构造方法
        String path1 = "C:\\itheima\\a.txt";
        File file = new File(path1);

        // 2.第二种构造方法
        String path2 = "C:\\itheima";
        String path3 = "a.txt";
        File file1 = new File(path2, path3);

        // 3.第三种构造方法
        File file2 = new File("C:\\itheima");
        String file3 = "a.txt";
        File file4 = new File(file2, file3);
    }
}
