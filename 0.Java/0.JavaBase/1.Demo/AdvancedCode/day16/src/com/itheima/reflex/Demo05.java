package com.itheima.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.获取字节码文件对象
        Class<?> clazz = Class.forName("com.itheima.reflex.Student");

        // 2.构造对象
        Constructor<?> constructor = clazz.getConstructor();
        Object o = constructor.newInstance();

        // 3.生成方法对象
        Method study = clazz.getMethod("study");

        //4.调用方法
        study.invoke(o);
    }
}