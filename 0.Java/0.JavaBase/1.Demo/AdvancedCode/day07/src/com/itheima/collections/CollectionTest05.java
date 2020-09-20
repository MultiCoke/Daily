package com.itheima.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest05 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        // 1.get(int index)
        System.out.println(list.get(0));

        // 2.set(int index, E e)
        list.set(0,"c");
        System.out.println(list);

        // 3.remove(int index)
        list.remove(0);
        System.out.println(list);

        // 4.add(int index, E e)
        list.add(0, "a");
        System.out.println(list);
    }
}
