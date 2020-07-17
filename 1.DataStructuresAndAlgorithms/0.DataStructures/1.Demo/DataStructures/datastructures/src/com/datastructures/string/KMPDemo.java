package com.datastructures.string;

import java.util.Arrays;

public class KMPDemo {
    public static void main(String[] args) {
        String s = "abaaabaaaabababacabad";
        String t = "ababac";
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        tChar = add(tChar);
        System.out.println(Arrays.toString(next(tChar)));
    }

    //  计算next数组
    public static int[] next(char[] ch){
        int[] next = new int[ch.length];
        //  固定移动
        int i = 1;
        //  数组下标
        int j = 0;
        //  0号元素发生匹配失败，j回到0
        next[1] = 0;
        //  遍历数组，求next数组其他元素
        while(i < ch.length-1){
            if(j == 0 ||ch[i] == ch[j]){
                next[++i] = ++j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    //  开始匹配
    public static void match(char[] s, char[] t, int[] next){
        int i = 1;
        int j = 1;
        while(i < s.length - 1 && j < t.length - 1){
            if(t[j] == s[i]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
    }

    //  字符数组加一
    public static char[] add(char[] ch){
        char[] temp = new char[ch.length + 1];
        temp[0] = 0;
        for (int i = 0; i < ch.length; i++) {
            temp[i + 1] = ch[i];
        }
        return temp;
    }
}
