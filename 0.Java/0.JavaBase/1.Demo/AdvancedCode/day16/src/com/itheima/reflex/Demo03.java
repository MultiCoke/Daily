package com.itheima.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.获取字节码文件对象及构造器
        Class<?> clazz = Class.forName("com.itheima.reflex.Student");
        Constructor<?> c1 = clazz.getConstructor();
        Constructor<?> c2 = clazz.getConstructor(String.class, int.class);

        // 2.使用无参构造器生成对象
        Object o1 = c1.newInstance();
        System.out.println(o1);

        // 3.使用有参构造器生成对象
        Object o2 = c2.newInstance("lisi", 24);
        System.out.println(o2);
    }
}