package com.itheima.demo02;

import java.util.concurrent.CountDownLatch;

public class Demo04 {
    /*
    请使用CountDownLatch编写一个程序，实现以下效果：
	线程A打印：”开始计算”
	线程B：计算1--100所有数的累加和，并打印结果。
	线程A打印：”计算完毕”
     */
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new RunnableA(countDownLatch)).start();
        new Thread(new RunnableB(countDownLatch)).start();
    }
}

class RunnableA implements Runnable{
    private CountDownLatch count;

    public RunnableA(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("开始计算");
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("计算完毕");
    }
}

class RunnableB implements Runnable{
    private CountDownLatch count;

    public RunnableB(CountDownLatch count) {
        this.count = count;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1--100所有数的累加和为：" + sum);
        count.countDown();
    }
}