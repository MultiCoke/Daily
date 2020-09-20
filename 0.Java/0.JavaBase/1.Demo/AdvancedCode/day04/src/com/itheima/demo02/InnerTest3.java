package com.itheima.demo02;

public class InnerTest3 {
    public static void main(String[] args) {
        Outer3.Inner3 inner3 = new Outer3.Inner3();
        inner3.show();
    }
}

class Outer3{
    static class Inner3{
        int a = 10;
        public void show(){
            System.out.println("Inner3");
        }
    }
}