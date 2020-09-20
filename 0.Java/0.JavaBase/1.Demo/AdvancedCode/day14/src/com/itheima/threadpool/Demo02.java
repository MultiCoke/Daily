package com.itheima.threadpool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Demo02 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 5, 2,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();
    }
}
