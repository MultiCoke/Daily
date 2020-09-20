package com.itheima.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo01 {
    public static void main(String[] args) throws ParseException{
        try {
            method1(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("method1 exception");
    }

    public static void method1(int[] arr) {
        if(arr == null){
            throw new NullPointerException();
        }else{
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void method2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.parse("2020/11/11");
    }
}
