package com.itheima.works;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo04 {
    /*
        定义一个Person类，包含私有属性name、age，getXxx和setXxx方法和有参满参构造方法。
        使用反射的方式创建一个实例、调用构造函数初始化name、age。使用反射方式调用setName方法对姓名进行设置，
        不使用setAge方法直接使用反射方式对age赋值。
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?> clazz = Class.forName("com.itheima.works.Student");

        Constructor<?> constructor = clazz.getConstructor();
        Student o = (Student) constructor.newInstance();

        Method setName = clazz.getMethod("setName", String.class);
        setName.invoke(o, "zhangsan");

        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(o, 23);

        System.out.println(o);
    }
}