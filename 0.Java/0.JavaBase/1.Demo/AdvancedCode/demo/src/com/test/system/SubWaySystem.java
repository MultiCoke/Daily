package com.test.system;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SubWaySystem {
    private static ArrayList<Manager> managers = new ArrayList<>();
    private static ArrayList<Subway> subways = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        init();
        System.out.println("请输入工号：");
        String id = sc.next();
        System.out.println("请输入姓名：");
        String name = sc.next();

        boolean flag = false;
        for (Manager manager : managers) {
            if (manager.getId().equals(id) && manager.getName().equals(name)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("登录成功");
            menu();
        } else {
            System.out.println("登录失败");
        }
    }

    public static void init() throws IOException {
        // 初始化管理员信息
        BufferedReader br1 = new BufferedReader(new FileReader("demo\\managers.txt"));
        String line1;

        while ((line1 = br1.readLine()) != null) {
            String[] info = line1.split(",");
            managers.add(new Manager(info[0], info[1], info[2], info[3]));
        }
        br1.close();

        // 初始化地铁站信息
        BufferedReader br2 = new BufferedReader(new FileReader("demo\\subways.txt"));
        String line2;

        while ((line2 = br2.readLine()) != null) {
            String[] info = line2.split(",");
            subways.add(new Subway(info[0], info[1], info[2]));
        }
        br2.close();
    }

    public static void menu() throws IOException {
        boolean flag = true;
        while (flag) {
            System.out.println("请选择功能：");
            System.out.println("1.查看地铁站");
            System.out.println("2.添加地铁站");

            int key = sc.nextInt();
            switch (key) {
                case 1:
                    query();
                    break;
                case 2:
                    addStation();
                    flag = false;
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入");
                    break;
            }
        }
    }

    private static void query() {
        if (subways.size() == 0) {
            System.out.println("暂无地铁站信息，请添加后查询");
        } else {
            System.out.println("地铁站信息如下：");
            for (Subway subway : subways) {
                System.out.println(subway);
            }
        }
    }

    private static void addStation() throws IOException {
        String no = "";
        System.out.println("请输入地铁编号：");
        while (true) {
            boolean flag = false;
            no = sc.next();
            for (Subway subway : subways) {
                if (subway.getNo().equals(no)) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                System.out.println("地铁编号重复，请重新输入：");
            } else {
                break;
            }
        }

        System.out.println("请输入地铁名称：");
        String name = sc.next();
        System.out.println("请输入所属路线：");
        String line = sc.next();
        Subway newSubway = new Subway(no, name, line);
        subways.add(newSubway);

        BufferedWriter bw = new BufferedWriter(new FileWriter("demo\\subways.txt", true));
        String add = no + "," + name + "," + line;
        bw.newLine();
        bw.write(add);
        bw.close();
    }
}