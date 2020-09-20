package com.itheima.reflex;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1.通过文件名获取字节码文件对象
        Class clazz1 = Class.forName("com.itheima.reflex.Student");

        // 2.通过类型获取字节码文件对象
        Class clazz2 = Student.class;

        // 3.通过实例获取字节码文件对象
        Student stu = new Student();
        Class clazz3 = stu.getClass();

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
    }
}