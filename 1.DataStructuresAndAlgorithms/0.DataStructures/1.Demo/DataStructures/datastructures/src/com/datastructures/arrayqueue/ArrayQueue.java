package com.datastructures.arrayqueue;

/**
 * @author XH
 * @Package com.datastructures.arrayqueue
 * @date 2020/7/3 22:08
 */
public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void add(int n){
        if(isFull()){
            System.out.println("队列已满，无法添加");
        }
        arr[++rear] = n;
    }

    //从队列取出数据
    public int put(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出");
        }
        return arr[++front];
    }

    //展示队列元素
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //获取队列头部数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front + 1];
    }
}
