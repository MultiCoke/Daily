package com.itheima.threadgroup;

public class Demo02 {
    public static void main(String[] args) {
        // 复制一个线程数组到一个线程组
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.enumerate(threads);
    }
}
