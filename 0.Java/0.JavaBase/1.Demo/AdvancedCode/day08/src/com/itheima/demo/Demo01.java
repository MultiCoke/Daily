package com.itheima.demo;

import java.util.HashSet;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        while(true){
            int a = scanner.nextInt();
            if(a == -1){
                break;
            }
            set.add(a);
        }

        int sum = 0;
        for (Integer integer : set) {
            sum += integer;
        }
        System.out.println("sum: " + sum);
        System.out.println("avg: " + (double)sum / set.size());
    }
}
