package com.itheima.demo;

import com.itheima.set.Student;

import java.util.HashSet;
import java.util.Iterator;

public class Demo03 {
    public static void main(String[] args) {
        HashSet<Student> classSet1 = new HashSet<>();
        HashSet<Student> classSet2 = new HashSet<>();
        HashSet<HashSet<Student>> project = new HashSet<>();

        classSet1.add(new Student("q", 12));
        classSet1.add(new Student("w", 13));
        classSet1.add(new Student("w", 13));

        classSet2.add(new Student("a", 21));
        classSet2.add(new Student("s", 31));
        classSet2.add(new Student("d", 41));

        project.add(classSet1);
        project.add(classSet2);

        Iterator<HashSet<Student>> iterator = project.iterator();
        while (iterator.hasNext()){
            HashSet<Student> next = iterator.next();
            Iterator<Student> iterator1 = next.iterator();
            while(iterator1.hasNext()){
                System.out.println(iterator1.next());
            }
        }
        System.out.println("--------------------------------");

        for (HashSet<Student> students : project) {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
