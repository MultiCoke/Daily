package com.itheima.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行了");
        });

        Thread.sleep(1000);

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " 执行了");
        });

        executorService.shutdown();
    }
}
