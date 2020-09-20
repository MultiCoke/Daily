package com.itheima.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 1.获取字节码文件对象
        Class<?> clazz = Class.forName("com.itheima.reflex.Student");

        // 2.获取构造器
        Constructor<?> constructor = clazz.getConstructor();

        // 3.创建对象
        Object o = constructor.newInstance();

        // 4.设置属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "wangwu");
        System.out.println(o);
    }
}