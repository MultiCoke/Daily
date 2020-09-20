package com.itheima.threadgroup;

public class Demo01 {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组的名字： " +
                    Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字： " +
                    Thread.currentThread().getName());
        });
        testThread.start();
        System.out.println("执行main方法线程名字： " + Thread.currentThread().getName());
    }
}