package com.itheima.exception;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        student.setName(name);
        while(true){
            System.out.println("请输入年龄：");
            String age = sc.nextLine();
            try {
                int i = Integer.parseInt(age);
                student.setAge(i);
                break;
            }
            catch (NumberFormatException | AgeOutOfRangeException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println(student);
    }
}

class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeOutOfRangeException {
        if(age >= 18 && age <= 30){
            this.age = age;
        }else{
            throw new AgeOutOfRangeException("请输入18~30岁之间的年龄");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}