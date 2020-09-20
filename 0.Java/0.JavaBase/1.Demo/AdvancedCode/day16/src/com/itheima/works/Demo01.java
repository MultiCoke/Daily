package com.itheima.works;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo01 {
    /*
        定义一个Student类，用反射去创建一个Student对象，要求使用两种方式：
            1.通过Class对象的方法创建。
            2.通过Constructor对象的方法创建。
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1.获取字节码文件对象
        Class<?> clazz = Class.forName("com.itheima.works.Student");

        // 2.获取无参构造器
        Constructor<?> c1 = clazz.getConstructor();

        // 3.使用无参构造器创建对象
        Student o1 = (Student) c1.newInstance();

        // 4.获取有参构造器
        Constructor<?> c2 = clazz.getConstructor(String.class, int.class);

        // 5.使用有参构造器创建对象
        Student o2 = (Student) c2.newInstance("zhangsan", 23);
    }
}