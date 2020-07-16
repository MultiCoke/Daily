package com.datastructures.arrayqueue;

import java.util.Scanner;

/**
 * @author XH
 * @Package com.datastructures.arrayqueue
 * @date 2020/7/4 0:08
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue caq = new CircleArrayQueue(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("q:展示数据");
            System.out.println("a:插入数据");
            System.out.println("o:取出数据");
            System.out.println("h:展示头部数据");
            System.out.println("e:退出");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 'q':
                    caq.show();
                    break;
                case 'a':
                    System.out.println("请输入数据：");
                    int a = scanner.nextInt();
                    caq.addQueue(a);
                    break;
                case 'o':
                    try {
                        System.out.println(caq.outQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(caq.headQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
            }
            System.out.println();
        }
    }
}

class CircleArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front = 0; // 指向第一个数据
        rear = 0; // 指向最后一个数据的后一位
        arr = new int[maxSize]; // 最后一个位置不存储数据，当队列满时好判断a
    }

    //判断队列是否为满
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        System.out.println(rear);
        if(isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //从队列取出数据
    public int outQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，无法取出");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //展示队列元素
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front; i < front + (rear + maxSize - front) % maxSize; i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //获取队列头部数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有头数据");
        }
        return arr[front];
    }

}
