package com.itheima.works;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo03 {
    /*
        定义一个类，在类中定义一个成员方法 show ，方法功能是：打印一个字符串。
        使用反射机制创建该类的对象，并调用该对象的 show 方法。
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("com.itheima.works.Student");

        Constructor<?> constructor = clazz.getConstructor();
         Object o = constructor.newInstance();

        Method method = clazz.getMethod("show");
        method.invoke(o);
    }
}
