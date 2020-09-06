package com.leetcode.simple;

public class S204 {
            /*
        204. 计数质数
        统计所有小于非负整数 n 的质数的数量。

        示例:

        输入: 10
        输出: 4
        解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
         */
    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }

    public static int countPrimes(int n) {
        boolean[] bool = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(!bool[i]){
                count++;
                for(int j=2; j*i < n; j++){
                    bool[j*i] = true;
                }
            }
        }

        return count;
    }
}
