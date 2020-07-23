package com.datastructures.stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();

    }
}

//  链表栈
class LinkedStack<E>{
    private LsNode<E> top;
    private int length;

    public LinkedStack() {
        this.top = null;
        length = 0;
    }

    public int getLength() {
        return length;
    }

    //  入栈
    public void push(E e){
        LsNode<E> pushN = new LsNode<>(e);
        pushN.next = top;
        top = pushN;
        length++;
    }

    //  出栈
    public Object pop(){
        if(top == null){
            System.out.println("空栈");
            return null;
        }
        LsNode<E> temp = top;
        top = top.next;
        temp.next = null;
        length--;
        return temp;
    }

    //  判断栈是否为空
    public boolean isEmpty(){
        return length == 0;
    }

    //  遍历
    public void list(){
        if(top == null){
            System.out.println("空栈");
            return;
        }
        LsNode<E> temp = top;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}



//  节点
class LsNode<E>{
    public E data;
    public LsNode<E> next;

    public LsNode(E data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "LsNode{" +
                "data=" + data +
                '}';
    }
}