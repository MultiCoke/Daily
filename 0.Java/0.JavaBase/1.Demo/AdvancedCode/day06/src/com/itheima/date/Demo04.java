package com.itheima.date;

import java.time.LocalDateTime;

public class Demo04 {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2002, 11, 11, 11, 11, 11);

        System.out.println(time.getYear());
        System.out.println(time.getMonthValue());
        System.out.println(time.getDayOfMonth());
        System.out.println(time.getHour());
        System.out.println(time.getMinute());
        System.out.println(time.getSecond());
    }
}