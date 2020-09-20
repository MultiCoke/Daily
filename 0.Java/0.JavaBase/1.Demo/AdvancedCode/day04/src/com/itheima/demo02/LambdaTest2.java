package com.itheima.demo02;

public class LambdaTest2 {
    public static void main(String[] args) {
        method((String msg) -> {
            System.out.println("Lambda " + msg);
        });
    }

    public static void method(ShowHandler2 showHandler2){
        showHandler2.printMessage("forgit it");
    }
}

interface ShowHandler2{
    void printMessage(String msg);
}