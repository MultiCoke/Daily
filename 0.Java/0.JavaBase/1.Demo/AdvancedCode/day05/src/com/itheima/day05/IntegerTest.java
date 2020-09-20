package com.itheima.day05;

public class IntegerTest {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = Integer.valueOf("100");

        System.out.println(i1);
        System.out.println(i2);

        // String -> int
        String s = "100";
        int a = Integer.parseInt(s);

        //  int -> String
        int b = 200;
        String s1 = String.valueOf(b);
        String s2 = Integer.toString(b);

        String s3 = "11 22 33";
        String[] strings = s3.split(" ");

        int[] arr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
