package com.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class S118 {
    /*
    118. 杨辉三角
    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    在杨辉三角中，每个数是它左上方和右上方的数的和。

    示例:

    输入: 5
    输出:
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
    ]
     */
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (int i = 0; i < generate.size(); i++) {
            List<Integer> integers = generate.get(i);
            System.out.println(integers);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0){
            return list;
        }
        ArrayList<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        list.add(firstList);

        for (int i = 1; i < numRows; i++) {
            List<Integer> nextList = new ArrayList<>();
            nextList.add(1);
            for (int j = 1; j < i; j++) {
                nextList.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
            }
            nextList.add(1);
            list.add(nextList);
        }
        return list;
    }
}
