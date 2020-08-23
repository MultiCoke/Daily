package com.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class S350 {
    /*
    350. 两个数组的交集 II
    给定两个数组，编写一个函数来计算它们的交集。

    示例 1：

    输入：nums1 = [1,2,2,1], nums2 = [2,2]
    输出：[2,2]
    示例 2:

    输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出：[4,9]
     */
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    // 1.哈希表
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null ){
            return null;
        }

        if(nums1.length == 0|| nums2.length == 0){
            return nums1.length == 0 ? nums1 : nums2;
        }

        HashMap<Integer,Integer> nums1Set = new HashMap<>();
        HashMap<Integer,Integer> result = new HashMap<>();

        for (int i : nums1) {
            if(!nums1Set.containsKey(i)){
                nums1Set.put(i, 1);
            }else{
                nums1Set.put(i, nums1Set.get(i) + 1);
            }
        }

        for (int i : nums2) {
            if(nums1Set.containsKey(i) && nums1Set.get(i) > 0){
                if(!result.containsKey(i)){
                    result.put(i, 1);
                }else{
                    result.put(i, result.get(i) + 1);
                }
                nums1Set.put(i, nums1Set.get(i) - 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : result.keySet()) {
            for(int i = 0; i < result.get(num); i++){
                list.add(num);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
