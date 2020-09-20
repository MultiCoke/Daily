package com.itheima.genericity;

public class Box<E> {
    private E e;

    public Box() {
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
