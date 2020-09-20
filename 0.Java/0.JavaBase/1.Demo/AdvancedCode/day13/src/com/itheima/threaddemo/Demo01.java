package com.itheima.threaddemo;

public class Demo01 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}

// 1.继承Thread类实现多线程
class MyThread extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println(this.getName() + ": play");
        }
    }
}