package com.itheima.works;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Demo02 {
    /*
        定义一个Student类，用反射去创建一个Student对象，要求使用两种方式：
            1.通过Class对象的方法创建。
            2.通过Constructor对象的方法创建。
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        Class<? extends ArrayList> clazz = list.getClass();
        Method add = clazz.getMethod("add", Object.class);

        add.invoke(list, "abc");
        System.out.println(list);
    }
}