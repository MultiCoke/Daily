package com.itheima.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Demo03 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

        List<Integer> collect = list.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);

        Set<Integer> collect1 = list.stream().filter(number -> number % 2 != 0).collect(Collectors.toSet());
        System.out.println(collect1);
        System.out.println(collect1 instanceof HashSet);
    }
}
