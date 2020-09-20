package com.itheima.date;

import java.time.Duration;
import java.time.LocalDateTime;

public class Demo08 {
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 11, 11, 11, 1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2023, 11, 11, 11, 11, 1);

        Duration between = Duration.between(localDateTime1, localDateTime2);
        System.out.println(between);
        System.out.println(between.toSeconds());
        System.out.println(between.toMillis());
        System.out.println(between.toNanos());
    }
}
