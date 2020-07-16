package com.datastructures.stack;

public class LinkedStackDemo {
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();
        ls.pop();
        ls.push(1);
        ls.push(2);
        ls.push(3);
        ls.push(4);
        ls.push(5);
        ls.pop();
        ls.pop();
        ls.pop();
        System.out.println(ls.getCount());
        ls.list();
    }
}

//  链表栈
class LinkedStack<E>{
    private LsNode<E> top;
    private int count;

    public LinkedStack() {
        this.top = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    //  入栈
    public void push(E e){
        LsNode<E> pushN = new LsNode<>(e);
        pushN.next = top;
        top = pushN;
        count++;
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
        count--;
        return temp;
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