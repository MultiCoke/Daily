package com.itheima.variableparameter;

public class Demo01 {
    public static void main(String[] args) {
        int sum = getSum(1, 2, 3, 4, 5);
        System.out.println(sum);
    }

    public static int getSum(int...arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
