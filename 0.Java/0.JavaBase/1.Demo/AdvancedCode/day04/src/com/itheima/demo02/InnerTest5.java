package com.itheima.demo02;

public class InnerTest5 {
    public static void main(String[] args) {
        new ShowHandler(){

            @Override
            public void show() {
                System.out.println("interface show()");
            }
        }.show();
    }
}

