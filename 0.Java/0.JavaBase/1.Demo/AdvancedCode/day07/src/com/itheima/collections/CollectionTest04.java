package com.itheima.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionTest04 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("小皮", 23);
        Student stu2 = new Student("小路", 31);
        Student stu3 = new Student("小贾", 33);

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        // 1.迭代器遍历
        Iterator<Student> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------");

        // 2.增强for
        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("-------------------------");

        // 3.普通for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
