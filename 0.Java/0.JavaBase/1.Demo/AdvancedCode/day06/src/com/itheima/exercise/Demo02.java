package com.itheima.exercise;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo02 {
    /*
    请编写程序，从控制台接收一个“日期”，格式：yyyy-MM-dd，程序将其转换为：xxxx年xx月xx日的格式输出到控制台。
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个日期，格式yyyy-MM-dd");

        String birthday = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birthday);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        String format = sdf1.format(parse);
        System.out.println(format);
    }
}
