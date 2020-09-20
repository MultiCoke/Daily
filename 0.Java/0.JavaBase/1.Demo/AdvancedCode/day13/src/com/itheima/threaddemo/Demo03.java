package com.itheima.threaddemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc1 = new MyCallable();
        FutureTask<String> ft1 = new FutureTask<>(mc1);
        Thread t1 = new Thread(ft1);

        MyCallable mc2 = new MyCallable();
        FutureTask<String> ft2 = new FutureTask<>(mc2);
        Thread t2 = new Thread(ft2);

        t1.start();
        t2.start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());
    }
}

// 3.实现Callable接口及创建FutureTask对象

class MyCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }

        return Thread.currentThread().getName().equals("Thread-0") ? "0" : "1";
    }
}