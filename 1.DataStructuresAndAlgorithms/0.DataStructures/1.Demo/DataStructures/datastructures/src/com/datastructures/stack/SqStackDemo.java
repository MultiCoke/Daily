package com.datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class SqStackDemo {
    public static void main(String[] args) {
//        int[] a = {1, -2, -2, -2};
//        fight(a);

        Sqstack<Integer> ss = new Sqstack<Integer>(5);
        ss.push(1);
        ss.push(2);
        ss.push(3);
        ss.push(4);
        ss.push(5);
        ss.pop();
        ss.list();
    }

    //  行星碰撞问题
    public static Stack<Integer> fight(int [] arr){
        Stack<Integer> fighter = new Stack<Integer>() ;
        for (int i : arr) {
            if(fighter.empty() || i > 0){
                fighter.push(i);
            }else{
                while(true){
                    if(fighter.peek() < 0 ){
                        fighter.push(i);
                        break;
                    }else if(i < -fighter.peek()){
                        fighter.pop();
                        if(fighter.empty()){
                            fighter.push(i);
                            break;
                        }
                        continue;
                    }else if(i + fighter.peek() == 0){
                        fighter.pop();
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        return fighter;
    }
}

//  顺序栈
class Sqstack<E>{
    private Object[] data;
    private int top;
    private int maxSize;

    public Sqstack(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
        this.top = -1;
    }

    //  进栈
    public boolean push(E e){
        if(top == maxSize - 1){
            return false;
        }
        data[++top] = e;
        return true;
    }

    //  出栈
    public Object pop(){
        if(top == -1){
            return null;
        }
        return data[top--];
    }

    // 遍历
    public void list(){
        if(top == -1){
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(data[i]);
        }
    }
}
