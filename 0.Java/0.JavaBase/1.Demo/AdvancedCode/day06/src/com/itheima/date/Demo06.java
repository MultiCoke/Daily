package com.itheima.date;

import java.time.LocalDateTime;

public class Demo06 {
    public static void main(String[] args) {
        // 增加减少时间
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.plusYears(1L);
        System.out.println(localDateTime);
    }
}
