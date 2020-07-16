package com.datastructures.stack;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class RPNCalculatorDemo {
    public static void main(String[] args) throws Exception {
        // 扫描接受一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入计算表达式：");
        String infixExpression = sc.nextLine();

        RPNCalculator rc = new RPNCalculator();
        System.out.println(rc.calculator(infixExpression));
    }
}

//  逆波兰计算器表达式
class RPNCalculator{
    private  Map<String, Integer> map = new HashMap<>();

    public RPNCalculator() {
        //  判断优先级的map
        map.put("+", 0);
        map.put("-", 0);
        map.put("*", 1);
        map.put("/", 1);
        map.put("(", -1);
        map.put(")", -1);
        map.put("#", -2);
    }

    //  检查表达式是否合法
    public void check(String infixExpreesion) throws Exception {
        //  接受一个中缀表达式，转换成字符数组
        char[] chars = infixExpreesion.toCharArray();
        //  表达式不能为空
        if(chars.length == 0){
            throw new Exception("输入不能为空");
        }
        //  用于判断括号的栈
        Stack<Character> cs = new Stack<>();
        //  保存上一个字符
        char last = ' ';
        //  遍历数组
        for (int i = 0; i < chars.length; i++) {
            switch(chars[i]){
                case '(':
                    cs.push(chars[i]);
                    break;
                case ')':
                    if(cs.empty() || cs.peek() != '('){
                        throw new Exception("表达式错误");
                    }else{
                        cs.pop();
                    }
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    //  运算符不能出现在开始或结尾
                    if(i == 0 || i == chars.length - 1){
                        throw new Exception("表达式错误");
                    }
                    //  运算符前一位不能为左括号或运算符
                    if(chars[i - 1] == '(' || chars[i - 1] == '+' || chars[i - 1] == '-' || chars[i - 1] == '*' || chars[i - 1] == '/'){
                        throw new Exception("表达式错误");
                    }
                    //  运算符的后一位不能为右括号或运算符
                    if(chars[i + 1] == ')' || chars[i + 1] == '+' || chars[i + 1] == '-' || chars[i + 1] == '*' || chars[i + 1] == '/'){
                        throw new Exception("表达式错误");
                    }
                    last = chars[i];
                    break;
                case '0':
                    if(last == '/'){
                        throw new Exception("表达式错误");
                    }
                    break;
                default:
                    last = chars[i];
                    break;
            }
        }
    }

    //  转换中缀表达式为后缀表达式
    public Stack<String> change(String infix){
        infix = infix.replaceAll("\\s*", "");
        char[] chars = infix.toCharArray();
        //  创建一个栈存储转换后的表达式
        Stack<String> suffixStack = new Stack<>();
        //  创建一个栈用于比较运算符，栈顶插入优先级最低的#
        Stack<String> operatorStack = new Stack<>();
        operatorStack.push("#");

        //  扫描每个字符
        for (int i = 0; i < chars.length; i++) {
            switch(chars[i]){
                case '(':
                    operatorStack.push(chars[i] + "");
                    break;
                case ')':
                    while(!operatorStack.peek().equals("(")){
                        suffixStack.push(operatorStack.pop());
                    }
                    operatorStack.pop();
                    break;
                case '+':
                case '-':
                case '*':
                case '/':
                    if(map.get(chars[i] + "") > map.get(operatorStack.peek())){
                            operatorStack.push(chars[i] + "");
                    }else{
                        while(!(map.get(chars[i] + "") > map.get(operatorStack.peek()))){
                            suffixStack.push(operatorStack.pop());
                        }
                        operatorStack.push(chars[i] +"");
                    }
                    break;
                default:
                    //  处理多位数或小数的缓冲区
                    StringBuilder sb = new StringBuilder();
                    while(Character.isDigit(chars[i]) || chars[i] == '.'){
                        sb.append(chars[i]);
                        if(i < chars.length - 1 && (Character.isDigit(chars[i + 1]) || chars[i + 1] == '.')){
                            i++;
                        }else{
                            break;
                        }
                    }
                    suffixStack.push(sb.toString());
                    break;
            }

        }

        //  运算符栈全部出栈，送入后缀表达式栈
        while(!operatorStack.peek().equals("#")){
            suffixStack.push(operatorStack.pop());
        }

        //  出栈前做一下逆序处理
        Stack<String> result = new Stack<>();
        while(!suffixStack.empty()){
           result.push(suffixStack.pop());
        }
        return result;
    }

    //  计算
    public double calculator(String str) throws Exception {
        check(str);
        //  中缀表达式转换为后缀表达式
        Stack<String> stack = change(str);
        System.out.println(stack);
        //  临时存储计算机结果
        Stack<Double> temp = new Stack<>();
        while(!stack.empty()){
            String s = stack.pop();
            if(Character.isDigit(s.charAt(0))){
                temp.push(Double.valueOf(s));
            }else{
                double a = temp.pop();
                double b = temp.pop();
                switch (s){
                    case "+":
                        temp.push(a + b);
                        break;
                    case "-":
                        temp.push(b - a);
                        break;
                    case "*":
                        temp.push(a * b);
                        break;
                    case "/":
                        BigDecimal a1 = new BigDecimal(a);
                        BigDecimal b1 = new BigDecimal(b);
                        temp.push(b1.divide(a1, 3, BigDecimal.ROUND_HALF_UP).doubleValue());
                        break;
                }
            }
        }
        return temp.pop();
    }
}