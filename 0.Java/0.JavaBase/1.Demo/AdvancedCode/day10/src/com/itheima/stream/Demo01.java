package com.itheima.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Demo01 {
    public static void main(String[] args) {
        // 获取Stream流
        // 1.单列集合
        ArrayList<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();

        // 2.双列集合
        HashMap<Integer, Integer> map = new HashMap<>();
        Stream<Integer> stream1 = map.keySet().stream();
        Stream<Map.Entry<Integer, Integer>> stream2 = map.entrySet().stream();

        // 3. 数组
        int[] nums = new int[9];
        Arrays.stream(nums);

        // 4.同种数据类型的多个数据
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);


    }
}
