package com.leetcode.simple;

import java.util.Arrays;

public class S169 {
    /*
    169. 多数元素

    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例 1:

    输入: [3,2,3]
    输出: 3
    示例 2:

    输入: [2,2,1,1,1,2,2]
    输出: 2
     */
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement2(nums));

    }

    // 1.排序法
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 2.摩尔投票法
    public static int majorityElement2(int[] nums) {
        int num = nums[0];
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if(num == nums[i]){
                count++;
            }else{
                count--;
                if(count == 0){
                    num = nums[i + 1];
                }
            }
        }

        return num;
    }
}
