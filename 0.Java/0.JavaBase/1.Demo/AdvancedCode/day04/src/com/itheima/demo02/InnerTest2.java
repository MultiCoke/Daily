package com.itheima.demo02;

public class InnerTest2 {
    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        outer1.getInner1();
    }
}

class Outer1{
    private class Inner1{
        int a = 10;

        public void show(){
            System.out.println("Inner1");
        }
    }

    public void getInner1(){
        Inner1 inner1 = new Inner1();
        inner1.show();
    }
}
