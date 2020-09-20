package com.itheima.annodemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@ServletAnno(className = "com.itheima.annodemo.ServletDemo", methodName = "service")
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = Class.forName("com.itheima.annodemo.Demo03");
        ServletAnno annotation = clazz.getAnnotation(ServletAnno.class);

        String className = annotation.className();
        String methodName = annotation.methodName();

        Class<?> ins = Class.forName(className);
        Object obj = ins.newInstance();

        Method method = ins.getMethod(methodName);
        method.invoke(obj);
    }
}
