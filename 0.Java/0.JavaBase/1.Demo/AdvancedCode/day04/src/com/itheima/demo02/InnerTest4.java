package com.itheima.demo02;

public class InnerTest4 {
    public static void main(String[] args) {
        Outer4 outer4 = new Outer4();
        outer4.method();
    }
}

class Outer4{
    public void method(){
        int a = 10;
        class Inner{
            public void show(){
                System.out.println(a);
            }
        }

        Inner inner = new Inner();
        inner.show();
    }
}
