package com.leetcode.simple;

public class S7 {
    /*
    7. 整数反转
    给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

    示例 1:

    输入: 123
    输出: 321
     示例 2:

    输入: -123
    输出: -321
    示例 3:

    输入: 120
    输出: 21
     */
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        long n = 0;
        while(x != 0){
            n = n * 10 + x % 10;
            x = x / 10;
        }

        if((int) n != n){
            return 0;
        }
        return (int)n;
    }
}
