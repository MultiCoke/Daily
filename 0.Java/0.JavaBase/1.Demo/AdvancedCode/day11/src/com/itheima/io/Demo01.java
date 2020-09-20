package com.itheima.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("a.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file);
        fos.write('a');
        fos.close();
    }
}
