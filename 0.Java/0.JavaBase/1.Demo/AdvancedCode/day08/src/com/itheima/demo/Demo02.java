package com.itheima.demo;

import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedHashSet<Integer> nums = new LinkedHashSet<>();

        while(nums.size() < 6){
            nums.add(random.nextInt(33) + 1);
        }

        nums.add(random.nextInt(16) + 1);
        System.out.println(nums);
    }
}
