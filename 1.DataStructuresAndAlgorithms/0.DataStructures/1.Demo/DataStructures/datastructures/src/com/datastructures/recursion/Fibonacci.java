package com.datastructures.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fbi(31));
    }

    //  递归实现斐波那契数列
    public static int fbi(int n){
        if(n < 2){
            return n == 0 ? 0 :1;
        }
        return fbi(n -1) + fbi(n - 2);
    }
}
