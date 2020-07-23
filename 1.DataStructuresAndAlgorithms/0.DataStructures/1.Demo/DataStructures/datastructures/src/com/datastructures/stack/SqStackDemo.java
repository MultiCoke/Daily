package com.datastructures.stack;

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
    private Object[] obj;
    private int top;
    private int maxSize;
    private int length;

    public Sqstack(int maxSize) {
        this.maxSize = maxSize;
        this.obj = new Object[maxSize];
        this.top = -1;
        this.length = 0;
    }

    //  进栈
    public boolean push(E e){
        if(isFull()){
            return false;
        }
        obj[++top] = e;
        length++;
        return true;
    }

    //  出栈
    public Object pop(){
        if(isEmpty()){
            return null;
        }
        length--;
        return obj[top--];
    }

    //  判断栈是否为空
    public boolean isEmpty(){
        return top == -1;
    }

    //  判断栈是否满
    public boolean isFull(){
        return length == maxSize;
    }

    //  获取栈顶元素
    public E getTop(){
        if(isEmpty()){
            return null;
        }
        return (E) obj[top];
    }

    // 遍历
    public void list(){
        if(top == -1){
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.println(obj[i]);
        }
    }
}
