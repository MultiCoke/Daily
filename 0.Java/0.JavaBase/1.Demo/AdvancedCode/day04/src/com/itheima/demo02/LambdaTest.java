package com.itheima.demo02;

public class LambdaTest {
    public static void main(String[] args) {
        print(() -> {
            System.out.println("it.s past");
        });
    }

    public static void print(ShowHandler showHandler){
        showHandler.show();
    }
}
