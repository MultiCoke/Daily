package com.itheima.work;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demo02 {
    /*
    请使用继承Thread类的方式定义一个线程类，在run()方法中循环10次，每1秒循环1次，每次循环按“yyyy-MM-dd HH:mm:ss”的格式打印当前系统时间。
	请定义测试类，并定义main()方法，启动此线程，观察控制台打印。
     */
    public static void main(String[] args) {
        PrintDateTime t1 = new PrintDateTime();
        t1.start();
    }
}

class PrintDateTime extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }
}
