package com.itheima.exercise;

import java.util.Scanner;

public class Demo03 {
    /*
    请定义main()方法，在main()中按以下顺序要求编写代码：
  ​	分别从控制台接收两个整数
  ​	计算“第一个数 /第二个数”的结果，并打印；
  ​	为了防止第二个数为0导致异常，请在计算时使用异常处理。

  ​	当出现异常时，向用户打印：第二个数不能为0！！
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int first = sc.nextInt();
        System.out.println("请输入第二个数：");
        int second= sc.nextInt();

        try {
            int a = first / second;
            System.out.println(a);
        } catch (ArithmeticException e) {
            if (second == 0) {
                System.out.println("第二个数不能为0");
            }
        }
    }
}
