package com.itheima.date;

import java.util.Date;

public class Demo01 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        Date date1 = new Date(0L);
        System.out.println(date1);

        System.out.println(date.getTime());
        date.setTime(0L);
        System.out.println(date.getTime());
    }
}
