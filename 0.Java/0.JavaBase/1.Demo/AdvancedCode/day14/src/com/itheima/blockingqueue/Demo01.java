package com.itheima.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo01 {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        queue.put("汉堡包");
        System.out.println(queue.take());
        System.out.println(queue.take());

        System.out.println("程序结束了");


    }
}
