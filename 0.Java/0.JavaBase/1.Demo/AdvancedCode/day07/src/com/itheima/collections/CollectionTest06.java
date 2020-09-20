package com.itheima.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class CollectionTest06 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        // 1.普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        // 2.iterator
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();

        // 3.增强for
        for (String s : list) {
            System.out.println(s);
        }

        // 4.addFirst()
        list.addFirst("qqq");
        System.out.println(list);

        // 5.addList()
        list.addLast("zzz");
        System.out.println(list);

        // 6.getFirst()
        String first = list.getFirst();
        System.out.println(first);

        // 7.getLast()
        String last = list.getLast();
        System.out.println(last);

        // 8.removeFirst()
        String s = list.removeFirst();
        System.out.println(s);
        System.out.println(list);

        // 9.removeLast()
        String s1 = list.removeLast();
        System.out.println(s1);
        System.out.println(list);
    }
}