package com.itheima.day02;

public class A {
    private int age;

    public A() {
    }

    public A(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private static int member;

    public static void method(){
        System.out.println("A");
    }
}
