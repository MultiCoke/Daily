package com.itheima.work;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo04 {
    /*
    模拟实现一个定时器，每隔1秒输出一下表示当前时间的字符串
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}