package com.itheima.annodemo;

public class Demo01 {
    @Anno01(show1 = 1, show2 = "a")
    public void show(){
        System.out.println("show");
    }

    public void print(){
        System.out.println("print");
    }
}
