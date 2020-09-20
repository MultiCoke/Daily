package com.itheima.demo02;

public class InnerTest {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        System.out.println(inner.b);
    }
}

class Outer{
    private int a = 10;
    class Inner{
        int b = 100;
        int c = a;
        public void show(){
            System.out.println("Inner");
        }
    }
}