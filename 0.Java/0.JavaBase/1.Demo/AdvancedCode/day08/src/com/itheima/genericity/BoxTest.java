package com.itheima.genericity;

public class BoxTest {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setE("aaa");
        String e = stringBox.getE();
        System.out.println(e);

        Box<Integer> integerBox = new Box<>();
        integerBox.setE(111);
        Integer e1 = integerBox.getE();
        System.out.println(e1);
    }
}
