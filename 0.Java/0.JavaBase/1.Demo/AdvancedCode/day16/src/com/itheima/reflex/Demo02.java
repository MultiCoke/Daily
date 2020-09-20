package com.itheima.reflex;

import java.lang.reflect.Constructor;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 1.获取字节码对象
        Class<?> clazz = Class.forName("com.itheima.reflex.Student");

        // 2.获取所有公共构造函数
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        // 3.获取所有构造函数
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }

        // 4.获取单个公共构造函数
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        // 5.获取单个所有构造函数
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        System.out.println(declaredConstructor);
    }
}