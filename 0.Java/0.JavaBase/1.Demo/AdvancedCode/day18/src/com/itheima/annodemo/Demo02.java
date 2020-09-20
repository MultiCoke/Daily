package com.itheima.annodemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class<?> clazz = Class.forName("com.itheima.annodemo.Demo01");

        Object obj = clazz.getConstructor().newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Anno01.class)){
                method.invoke(obj);
            }
        }
    }
}