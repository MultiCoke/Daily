package com.itheima.demo02;

import java.util.concurrent.ConcurrentHashMap;

public class Demo03 {
    /*
    请使用ConcurrentHashMap定义一个线程安全的Map，使用两个线程访问它：
	第一个线程：向集合中添加键、值都是：1--10000的数字；
	第二个线程：向集合中添加键、值都是：10001--20000的数字；
	确保两个线程全部操作集合完毕，然后打印集合的每个元素，测试期准确性。
     */
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                map.put(i, i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 10001; i <= 20000; i++) {
                map.put(i, i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
