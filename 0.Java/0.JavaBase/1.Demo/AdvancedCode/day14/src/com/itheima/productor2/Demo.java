package com.itheima.productor2;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<String>(1);

        Cooker cooker = new Cooker(bd);
        Foodie foodie = new Foodie(bd);

        new Thread(foodie).start();
        new Thread(cooker).start();
    }
}
