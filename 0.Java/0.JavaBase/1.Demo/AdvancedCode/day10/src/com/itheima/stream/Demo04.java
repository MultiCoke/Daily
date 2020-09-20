package com.itheima.stream;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo04 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("zhangsan,23");
        list.add("lisi,22");
        list.add("wangwu,25");

        Map<String, Integer> collect = list.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 23)
                .collect(Collectors.toMap(
                s -> s.split(",")[0],
                s -> Integer.parseInt(s.split(",")[1])
        ));

        System.out.println(collect);
    }
}
