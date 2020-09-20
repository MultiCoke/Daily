package com.test.test21;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class Test21 {
    /*
    键盘录入3个学生信息(姓名,语文成绩,数学成绩,英语成绩)。
    要求按照成绩总分从高到低写入文本文件，最后在从文件中把读取数据显示在控制台
    格式：姓名,语文成绩,数学成绩,英语成绩 举例：林青霞,98,99,100
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        TreeSet<Student> set = new TreeSet<>((s1, s2) -> s2.getSum() - s1.getSum() == 0 ?
                (s2.getName().compareTo(s1.getName())) : s2.getSum() - s1.getSum());
        for (int i = 1; i <= 3; i++) {
            System.out.println("请录入第" + i + "个学生信息");
            System.out.println("请姓名：");
            String name = sc.next();

            System.out.println("语文成绩：");
            int chinese = sc.nextInt();
            System.out.println("数学成绩：");
            int math = sc.nextInt();
            System.out.println("英语成绩：");
            int english = sc.nextInt();

            Student student = new Student(name, chinese, math, english);
            set.add(student);
        }

        BufferedWriter fw = new BufferedWriter(new FileWriter("test21\\score.txt"));
        for (Student student : set) {
            fw.write(student.getName() + "," + student.getChinese() + "," + student.getMath() + "," + student.getEnglish());
            fw.newLine();
            fw.flush();
        }

        fw.close();
        System.out.println("数据写入文件完毕");

        BufferedReader br = new BufferedReader(new FileReader("test21\\score.txt"));
        System.out.println("文件中的数据展示如下：");
        System.out.println("姓名,语文成绩,数学成绩,英语成绩");
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
}