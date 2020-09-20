package com.itheima.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("张三丰");
        strings.add("张无忌");
        strings.add("张翠山");
        strings.add("王二麻子");
        strings.add("张良");
        strings.add("谢广坤");
        strings.add("谢广坤");

        // limit
        strings.stream().limit(2).forEach(System.out::println);
        System.out.println("----------------");

        // skip
        strings.stream().skip(2).forEach(System.out::println);
        System.out.println("----------------");

        // concat
        Stream.concat(strings.stream(), strings.stream()).forEach(System.out::println);
        System.out.println("----------------");

        // distinct
        strings.stream().distinct().forEach(System.out::println);
        System.out.println("----------------");

        // count
        System.out.println(strings.stream().count());
    }
}