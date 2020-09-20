package com.itheima.genericity;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));

        String[] strings = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(strings));
    }
}
