package com.itheima.day05;

import java.util.Arrays;

public class SystemTest {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = new int[8];

        long start = System.currentTimeMillis();
        System.arraycopy(a, 1, b, 1, a.length - 1);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(b));
        System.out.println("Time: " + (end - start) + " ms");
    }
}
