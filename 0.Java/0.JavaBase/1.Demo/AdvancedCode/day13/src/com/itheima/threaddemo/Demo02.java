package com.itheima.threaddemo;

public class Demo02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
    }
}

// 2.实现Runnable接口实现多线程
class MyRunnable implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ": action");
        }
    }
}
