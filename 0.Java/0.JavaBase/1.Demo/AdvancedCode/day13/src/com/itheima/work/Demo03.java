package com.itheima.work;

public class Demo03 {
    /*
    请使用继承Thread类的方式定义两个线程，一个线程可以计算1--100所有数字的累加和，
    另一个线程可以计算1--1000所有数字的累加和，每个线程计算完毕后各自打印计算结果，
    格式例如：”xxx线程计算1--100的累加和，结果：xxxx”
	请定义测试类，并定义main()方法，启动两个线程，观察控制台打印结果。
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 100 ; i++) {
                    sum += i;
                }
                System.out.println(Thread.currentThread().getName() + "计算1--100的累加和，结果为：" + sum);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                System.out.println(Thread.currentThread().getName() + "计算1--1000的累加和，结果为: " + sum);
            }
        }).start();
    }
}