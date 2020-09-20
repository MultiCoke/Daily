package com.itheima.hashset;

import java.util.HashSet;

public class StudentTest {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("xiaohei", 22));
        students.add(new Student("xiaohei", 22));
        students.add(new Student("xiaomei", 23));

        System.out.println(students);
    }
}