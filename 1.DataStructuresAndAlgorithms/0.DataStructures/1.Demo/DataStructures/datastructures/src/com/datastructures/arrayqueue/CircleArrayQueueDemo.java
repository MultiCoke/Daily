package com.datastructures.arrayqueue;

import java.util.Scanner;

/**
 * @author XH
 * @Package com.datastructures.arrayqueue
 * @date 2020/7/4 0:08
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleSqQueue<Integer> sq = new CircleSqQueue<Integer>(5);
        sq.enQueue(1);
        sq.enQueue(2);
        sq.enQueue(3);
        sq.enQueue(4);
        sq.enQueue(5);
        sq.deQueue();
        sq.enQueue(22);
        sq.enQueue(22);
        System.out.println(sq.length());

        sq.list();
    }
}

//  循环队列
class CircleSqQueue<E>{
    private int maxSize;
    private int front;  // 指向第一个数据
    private int rear;   // 指向最后一个数据的后一位
    private int length;
    private Object[] obj;

    public CircleSqQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        this.front = 0;
        this.rear = 0;
        this.length = 0;
        this.obj = new Object[maxSize + 1];
    }

    //  判断队列是否为满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //  判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //  入队列
    public void enQueue(E e){
        if(isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        obj[rear] = e;
        rear = (rear + 1) % maxSize;
        length++;
        System.out.println(rear);
    }

    //  出队列
    public E deQueue(){
        if(isEmpty()){
            return null;
        }
        E temp = (E)obj[front];
        front = (front + 1) % maxSize;
        length--;
        return temp;
    }

    //  获取队列头部数据
    public E headQueue(){
        if(isEmpty()){
            return null;
        }
        return (E)obj[front];
    }

    //  获取队列元素个数
    public int length(){
        return length;
    }

    //  遍历队列
    public void list(){
        if(isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front; i < front + (rear + maxSize - front) % maxSize; i++) {
            System.out.printf("%d\n",obj[i % maxSize]);
        }
    }
}
