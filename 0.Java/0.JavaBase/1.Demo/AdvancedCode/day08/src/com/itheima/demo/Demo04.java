package com.itheima.demo;

import java.util.Collection;
import java.util.TreeSet;

public class Demo04 implements IDataOperation<Student>{
    public static void main(String[] args) {
        Demo04 test = new Demo04();
        test.add(new Student("001", "x", "12", "zz"));
        test.add(new Student("002", "r", "13", "zz"));
        test.add(new Student("003", "c", "14", "zz"));
        System.out.println(test.getAll());

        test.delete("001");
        System.out.println(test.getAll());

        test.update(new Student("002", "d", "11", "zz"));
        System.out.println(test.getAll());

        System.out.println(test.get("003"));
    }
    private TreeSet<Student> students = new TreeSet<>();

    @Override
    public boolean add(Student t) {
        return students.add(t);
    }

    @Override
    public <T> boolean delete(T t) {
        return students.removeIf(next -> next.getId().equals(t));
    }

    @Override
    public <T> boolean update(Student student) {
        for (Student student1 : students) {
            if(student1.getId().equals(student.getId())){
                student1.setName(student.getName());
                student1.setAge(student.getAge());
                student1.setAddress(student.getAddress());
            }
            return true;
        }

        return false;
    }

    @Override
    public <T> Student get(T t) {
        for (Student student : students) {
            if(student.getId().equals(t)){
                return student;
            }
        }

        return null;
    }

    @Override
    public Collection<Student> getAll() {
        return students;
    }
}