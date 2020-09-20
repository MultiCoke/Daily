package com.itheima.edu.entry;

import com.itheima.edu.controller.StudentController;

import java.util.Scanner;

public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            //  主菜单搭建
            System.out.println("--------欢迎来到黑马信息管理系统--------");
            System.out.println("请输入您的选择：1.学生管理 2.老师管理 3.退出");
            String choice = sc.next();
            switch (choice){
                case "1":
                    //  开启学生管理系统
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    //  开启老师管理系统
                    break;
                case "3":
                    //  退出
                    System.out.println("感谢您的使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }
        }
    }
}
