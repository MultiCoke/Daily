package com.itheima.demo02;

public class CalculatorTest {
    public static void main(String[] args) {
        getSum((int a, int b) -> {
            return a + b;
        });
    }

    public static void getSum(Calculator calculator){
        int sum = calculator.sum(1, 2);
        System.out.println(sum);
    }
}

interface Calculator{
    int sum(int a, int b);
}