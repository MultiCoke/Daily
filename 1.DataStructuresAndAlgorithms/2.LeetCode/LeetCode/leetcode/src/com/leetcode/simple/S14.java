package com.leetcode.simple;

import java.util.Arrays;

public class S14 {
    /*
    14. 最长公共前缀
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
     */
    public static void main(String[] args) {
        String[] strs = {"c", "c"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);
        char[] min = strs[0].toCharArray();
        char[] max = strs[strs.length - 1].toCharArray();
        int index = -1;

        for (int i = 0; i < Math.min(min.length, max.length); i++) {
            if (min[i] != max[i]) {
                break;
            } else {
                index = i;
            }
        }

        if (index == -1) {
            return "";
        } else {
            return String.valueOf(Arrays.copyOfRange(min, 0, index + 1));
        }
    }
}
