package com.itheima.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo05 {
    public static void main(String[] args) {
        // 1.jdk8格式化字符串
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format = now.format(dtf);
        System.out.println(format);

        // 2.jdk8解析字符串
        String s = "2200-11-12 11:11:11";
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(s, dtf1);
        System.out.println(parse);
    }
}
