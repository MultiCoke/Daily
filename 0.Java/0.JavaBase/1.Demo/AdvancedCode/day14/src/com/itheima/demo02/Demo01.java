package com.itheima.demo02;

import java.util.Random;
import java.util.concurrent.*;

public class Demo01 {
    /*
    使用线程池,分别开启三条线程,生成10个1到100的随机数,然后计算他们的平均数, 最后计算这三个平均数的平均数.(使用Callable)
     */
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        MyCallable myCallable = new MyCallable();
        FutureTask<Double> task1 = new FutureTask<>(myCallable);
        FutureTask<Double> task2 = new FutureTask<>(myCallable);
        FutureTask<Double> task3 = new FutureTask<>(myCallable);

        pool.submit(task1);
        pool.submit(task2);
        pool.submit(task3);

        try {
            System.out.println ((task1.get() + task2.get() + task3.get()) / 3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }
}

class MyCallable implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        Random r = new Random();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += r.nextInt(100) + 1;
        }

        return sum / 10.0;
    }
}