package com.itheima.set;

import java.util.TreeSet;

public class Demo03 {
    public static void main(String[] args) {
        TreeSet<Teacher> teachers = new TreeSet<>((t1, t2) -> t1.getAge() - t2.getAge() == 0 ? t1.getName().compareTo(t2.getName()) : t1.getAge() - t2.getAge());
        Teacher t1 = new Teacher("x", 23);
        Teacher t2 = new Teacher("z", 22);
        Teacher t3 = new Teacher("c", 22);

        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);

        System.out.println(teachers);
    }
}
