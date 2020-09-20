package com.itheima.set;

import java.util.Iterator;
import java.util.TreeSet;

public class Demo01 {
    public static void main(String[] args) {
        TreeSet<String> strings = new TreeSet<>();
        strings.add("aaa");
        strings.add("aaa");
        strings.add("bbb");
        strings.add("ccc");

        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------");

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
