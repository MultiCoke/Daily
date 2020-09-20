package com.itheima.demo02;

public interface InterA {

    default void show(){
        log();
        System.out.println("A");
    }

    static void print(){
        System.out.println("print A");
    }

    private void log(){
        System.out.println("log");
    }
}
