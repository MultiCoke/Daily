package com.itheima.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo01 {
    /*
    请编写程序，从控制台接收一个“生日”，格式：yyyy-MM-dd，程序要能够计算并打印他来到世界xx天。
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个生日，格式yyyy-MM-dd");

        String birthday = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birthday);

        Date now = new Date();

        long l = now.getTime() - parse.getTime();
        System.out.println("你已来到世界" + l / 1000 / 60 / 60 / 24 + "天");
    }
}
