package com.itheima.charstream;

import java.io.*;
import java.util.Arrays;

public class Demo06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        String line = br.readLine();
        br.close();

        String[] lines = line.split(" ");

        int[] arr = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        Arrays.sort(arr);

        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        for (int i : arr) {
            bw.write(String.valueOf(i) + " ");
        }

        bw.close();
    }
}