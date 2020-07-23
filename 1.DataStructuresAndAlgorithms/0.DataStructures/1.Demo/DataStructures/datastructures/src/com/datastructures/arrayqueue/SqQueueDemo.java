package com.datastructures.arrayqueue;

public class SqQueueDemo{
    public static void main(String[] args) {
        SqQueue<Integer> sq = new SqQueue<Integer>(5);
        sq.enQueue(1);
        sq.enQueue(2);
        sq.enQueue(3);
        sq.enQueue(4);
        sq.enQueue(5);
        sq.enQueue(5);
        sq.deQueue();
        sq.enQueue(1);
        System.out.println(sq.length());

        sq.list();
    }
}

//  队列的顺序实现
class SqQueue<E>{
    private int maxSize;
    private int rear;
    private Object[] obj;

    public SqQueue(int maxSize) {
        this.maxSize = maxSize;
        this.rear = -1;
        this.obj = new Object[maxSize];
    }

    //  返回队列元素个数
    public int length(){
        return rear + 1;
    }

    //  判断队列是否为满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //  判断队列是否为空
    public boolean isEmpty(){
        return rear == -1;
    }

    //  入队列
    public void enQueue(E e){
        if(isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        obj[++rear] = e;
    }

    //  出队列
    public E deQueue(){
        if(isEmpty()){
            return null;
        }
        E temp = (E)obj[0];
        for (int i = 0; i <= rear; i++) {
            if(i < maxSize -1){
                obj[i] = obj[i+1];
            }else if(i == maxSize -1){
                obj[i] = null;
            }
        }
        rear--;
        return temp;
    }

    //  获取队列头部元素
    public E getHead(){
        return (E)obj[0];
    }

    //  遍历队列
    public void list(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < obj.length; i++) {
            if(obj[i] != null){
                System.out.printf("arr[%d] = %d\n", i, obj[i]);
            }
        }
    }
}
