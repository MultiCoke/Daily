package com.leetcode.simple;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class S387 {
    /*
    387. 字符串中的第一个唯一字符
    给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

    示例：

    s = "leetcode"
    返回 0

    s = "loveleetcode"
    返回 2
     */
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        if(s == null || s.length() == 0){
            return -1;
        }

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        Set<Character> set = map.keySet();
        for (Character ch : set) {
            if(map.get(ch) == 1){
                return s.indexOf(ch);
            }

        }

        return -1;
    }
}
