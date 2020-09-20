package com.itheima.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("a.txt");

        byte[] bytes = {'a', 'b', 'c', ' '};
        fos.write(bytes);

        byte[] b1 = "waiting for love".getBytes();
        fos.write(b1);

        fos.close();
    }
}
