package com.itheima.collections;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        // 1.add()
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        System.out.println(collection);

        // 2.remove()
        collection.remove("aaa");
        System.out.println(collection);

        // 3.removeIf()
        collection.removeIf((String s) -> {return "bbb".equals(s);});
        System.out.println(collection);

        // 4.contains()
        boolean aaa = collection.contains("aaa");
        boolean ccc = collection.contains("ccc");
        System.out.println(aaa);
        System.out.println(ccc);

        // 5.size()
        int size = collection.size();
        System.out.println(size);
    }
}
