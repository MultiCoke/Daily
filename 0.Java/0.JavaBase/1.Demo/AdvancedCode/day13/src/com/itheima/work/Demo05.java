package com.itheima.work;

public class Demo05 {
    /*
    开启三个线程，分别执行以下三个运算，并将运算结果输出到控制台。
    一个线程计算10!
    一个线程计算5!
    一个线程计算8!
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int mul = 1;
                for (int i = 1; i <= 10; i++) {
                    mul *= i;
                }
                System.out.println("10! = " + mul);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int mul = 1;
                for (int i = 1; i <= 5; i++) {
                    mul *= i;
                }
                System.out.println("5! = " + mul);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int mul = 1;
                for (int i = 1; i <= 8; i++) {
                    mul *= i;
                }
                System.out.println("8! = " + mul);
            }
        }).start();
    }
}