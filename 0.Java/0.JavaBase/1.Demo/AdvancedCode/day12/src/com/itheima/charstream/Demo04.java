package com.itheima.charstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Demo04 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        bw.write("黑马程序员");
        bw.newLine();
        bw.write("666");
        bw.close();
    }
}
