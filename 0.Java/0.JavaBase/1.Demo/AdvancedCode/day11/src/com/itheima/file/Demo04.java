package com.itheima.file;

import java.io.File;

public class Demo04 {
    public static void main(String[] args) {
        File src = new File("C:\\Users\\HY\\Desktop\\src");
        deleteDir(src);

    }

    private static void deleteDir(File src) {
        File[] files = src.listFiles();

        for (File file : files) {
            if(file.isFile()){
                file.delete();
            }else{
                deleteDir(file);
            }
        }

        src.delete();
    }
}
