package com.itheima.genericity;

import java.util.ArrayList;
import java.util.Collections;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Integer> integers = addElement(new ArrayList<Integer>(), 1, 2, 3);
        System.out.println(integers);
    }

    public static <T> ArrayList<T> addElement(ArrayList<T> list, T...is){
        Collections.addAll(list, is);
        return list;
    }
}
