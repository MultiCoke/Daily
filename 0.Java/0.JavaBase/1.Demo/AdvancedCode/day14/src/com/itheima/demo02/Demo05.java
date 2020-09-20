package com.itheima.demo02;

import java.util.concurrent.Semaphore;

public class Demo05 {
    /*
    请使用Semaphore编写一个程序，实现以下效果：有10名游客要参观展览室，而“展览室”同时只允许最多“三个游客”参观，
    每个游客参观时间2秒。
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Demo(semaphore, i)).start();
        }
    }
}

class Demo implements Runnable{
    private Semaphore semaphore;
    private int i;

    public Demo(Semaphore semaphore, int i) {
        this.semaphore = semaphore;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i + "开始参观");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
