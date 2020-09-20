package com.itheima.exricse;

import java.util.Arrays;

public class Demo03 {
    /*
        现有一个Integer数组如下：Integer[] arr = {1, 2, 3, 2, 3, 2, 2, 4, 2};

          1. 将数组中的元素收取到流中
          2. 去除掉流中重复的数据
          3. 打印流中每个数据
     */
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 2, 3, 2, 2, 4, 2};
        Arrays.stream(arr).distinct().forEach(System.out::println);
    }
}
