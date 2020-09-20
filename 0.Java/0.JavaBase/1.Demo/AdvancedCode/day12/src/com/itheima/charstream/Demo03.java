package com.itheima.charstream;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入账号：");
        String userName = sc.next();
        System.out.println("请录入密码：");
        String passWord = sc.next();

        FileWriter fw = new FileWriter("a.txt");
        fw.write(userName);
        fw.write("\r\n");
        fw.write(passWord);

        fw.flush();
        fw.close();
    }
}
