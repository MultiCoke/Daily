package com.itheima.edu.controller;

import com.itheima.edu.domain.Student;
import com.itheima.edu.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private Scanner sc = new Scanner(System.in);
    private StudentService studentService = new StudentService();

    public void start() {
        studentLoop: while(true){
            System.out.println("--------欢迎来到学生信息管理系统--------");
            System.out.println("请输入您的选择：1.添加学生 2.删除学生 3.修改学生 4.查看学生 5.退出");
            String choice = sc.next();
            switch (choice){
                case "1":
                    addStudent();
                    break;
                case "2":
                    deleteStudentById();
                    break;
                case "3":
                    updateStudentById();
                    break;
                case "4":
                    queryStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }
        }
    }

    public void updateStudentById() {
        String id = inputCheckOut();
        Student stu = inputInfo(id);
        studentService.updateStudentById(id, stu);
        System.out.println("更新成功");
    }

    public void queryStudent() {
        Student[] stus = studentService.queryStudent();
        if(stus == null){
            System.out.println("暂无信息，请添加后查询");
        }else{
            System.out.println("学号\t姓名\t年龄\t\t生日");
            for (int i = 0; i < stus.length; i++) {
                if(stus[i] != null){
                    System.out.println(stus[i].getId() + "\t" + stus[i].getName() + "\t" + stus[i].getAge() + "\t\t" + stus[i].getBirthday());
                }
            }
        }
    }

    public void deleteStudentById() {
        String id = inputCheckOut();
        studentService.deleteStudentById(id);
        System.out.println("删除成功");
    }

    public void addStudent() {
        String id;
        while(true){
            System.out.println("请输入学号：");
            id = sc.next();
            if(studentService.isExist(id)){
                System.out.println("学号已存在");
            }else{
                break;
            }
        }
        Student stu = inputInfo(id);
        boolean result = studentService.addStudent(stu);

        if(result){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public String inputCheckOut(){
        String id;
        while(true){
            System.out.println("请输入学号：");
            id = sc.next();
            if(studentService.isExist(id)){
                break;
            }else{
                System.out.println("学号不存在，请重新输入：");
            }
        }
        return id;
    }

    public Student inputInfo(String id){
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        String age = sc.next();
        System.out.println("请输入生日：");
        String birthday = sc.next();

        return new Student(id, name, age, birthday);
    }

}
