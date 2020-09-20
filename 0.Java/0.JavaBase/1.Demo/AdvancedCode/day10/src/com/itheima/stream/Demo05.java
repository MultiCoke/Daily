package com.itheima.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Demo05 {
    public static void main(String[] args) {
        ArrayList<String> manList = new ArrayList<>();
        manList.add("张国立");
        manList.add("张晋");
        manList.add("刘烨");
        manList.add("郑伊健");
        manList.add("徐峥");
        manList.add("王宝强");

        ArrayList<String> womenList = new ArrayList<>();
        womenList.add("郑爽");
        womenList.add("杨紫");
        womenList.add("关晓彤");
        womenList.add("张天爱");
        womenList.add("杨幂");
        womenList.add("赵丽颖");

        // 男演员只要名字为三个字的前两个
        Stream<String> stream1 = manList.stream().filter(s -> s.length() == 3).limit(2);

        // 女演员只要姓杨的，并且不要第一个
        Stream<String> stream2 = womenList.stream().filter(s -> s.startsWith("杨")).skip(1);

        // 合并两个流
        Stream.concat(stream1, stream2).forEach(
            s -> System.out.println(new Actor(s))
        );
    }
}

class Actor{
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                '}';
    }
}
