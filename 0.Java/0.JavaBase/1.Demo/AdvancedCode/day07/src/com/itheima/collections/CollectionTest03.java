package com.itheima.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest03 {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");
        collection.add("d");
        collection.add("e");

        for (String s : collection) {
            System.out.println(s);
        }
    }
}
