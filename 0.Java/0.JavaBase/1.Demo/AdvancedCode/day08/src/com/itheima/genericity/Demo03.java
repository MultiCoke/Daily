package com.itheima.genericity;

public class Demo03 {
    public static void main(String[] args) {
        GenericImpl1<String> g1 = new GenericImpl1<>();
        g1.method("a");

        GenericImpl2 generic = new GenericImpl2();
        generic.method(1);
    }
}

interface Generic<E>{
    void method(E e);
}

class GenericImpl1<E> implements Generic<E>{

    @Override
    public void method(E e) {
        System.out.println(e);
    }
}

class GenericImpl2 implements Generic<Integer>{

    @Override
    public void method(Integer integer) {
        System.out.println(integer);
    }
}
