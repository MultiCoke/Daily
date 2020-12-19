package com.leetcode.middle;

/**
 * @author Upmerge
 * @package com.leetcode.middle
 * @date 2020/12/11 18:30
 */
public class Test {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(drinkCount(94));
    }

    public static int drinkCount(int n){
        int sum = 0;
        return drink(n, sum);
    }

    public static int drink(int n, int sum){
        if(n == 0 || n == 1){
            return sum;
        }
        int n = 0;

        int temp = n / 3;
        sum += temp;
        n = n % 3 + temp;
        if(n == 2){
            sum += 1;
            n = 0;
        }
        return drink(n, sum);
    }
}
