package com.itheima.treeset;

import java.util.TreeSet;

public class StudentTest {
    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("zhangsan", 80, 80, 80 ));
        students.add(new Student("lisi", 90, 90, 90 ));
        students.add(new Student("wangwu", 100, 100, 100 ));

        System.out.println(students);
    }
}