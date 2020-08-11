package com.leetcode.simple;

import java.util.Stack;

public class S20 {
    /*
    20.有效的括号
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:

    输入: "()"
    输出: true
    示例 2:

    输入: "()[]{}"
    输出: true
    示例 3:

    输入: "(]"
    输出: false
    示例 4:

    输入: "([)]"
    输出: false
    示例 5:

    输入: "{[]}"
    输出: true
     */
    public static void main(String[] args) {
        String s = "";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        //  1.创建一个栈用于存放字符
        Stack<Character> chStack = new Stack<>();
        //  2.将字符串转换成字符数组
        char[] chArray = s.toCharArray();
        //  3.遍历字符数组进栈
        for (char c : chArray) {
            if(c == '(' ){
                chStack.push(')');
            }else if(c == '['){
                chStack.push(']');
            }else if(c == '{'){
                chStack.push('}');
            }else if(chStack.isEmpty() || c != chStack.pop()){
                return false;
            }
        }

        return chStack.isEmpty();
    }
}
