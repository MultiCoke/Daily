package com.itheima.productor2;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie implements Runnable {
    private ArrayBlockingQueue<String> bd;

    public Foodie(ArrayBlockingQueue<String> bd) {
        this.bd = bd;
    }

    @Override
    public void run() {
        while(true){
            String take = null;
            try {
                take = bd.take();
                System.out.println("吃货将" + take + "拿出来吃了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
