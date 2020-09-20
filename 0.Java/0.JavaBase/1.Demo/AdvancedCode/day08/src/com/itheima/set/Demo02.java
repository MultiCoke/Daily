package com.itheima.set;

import java.util.TreeSet;

public class Demo02 {
    public static void main(String[] args) {
        Student s1 = new Student("x", 12);
        Student s2 = new Student("g", 11);
        Student s3 = new Student("s", 13);
        Student s4 = new Student("v", 11);

        TreeSet<Student> students = new TreeSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println(students);
    }
}
