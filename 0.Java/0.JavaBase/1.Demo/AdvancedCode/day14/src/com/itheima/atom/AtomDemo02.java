package com.itheima.atom;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomDemo02 {
    public static void main(String[] args) {
        MyAtomThread02 mt = new MyAtomThread02();
        for (int i = 0; i < 100; i++) {
            new Thread(mt).start();
        }
    }
}

class MyAtomThread02 implements Runnable{
    AtomicInteger ac = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int count = ac.incrementAndGet();
            System.out.println("已经送了" + count + "个冰淇淋");
        }
    }
}
