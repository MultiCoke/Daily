package com.datastructures.arrayqueue;

public class LinkQueueDemo {
    public static void main(String[] args) {
        LinkQueue<Integer> lq = new LinkQueue<>();
        lq.enQueue(1);
        lq.enQueue(2);
        lq.enQueue(3);
        lq.enQueue(4);
        lq.deQueue();
        lq.deQueue();
        lq.deQueue();
        lq.deQueue();
        lq.list();
    }
}

//  链表队列
class LinkQueue<E>{
    private LQNode<E> front;
    private LQNode<E> rear;

    public LinkQueue() {
        this.front = new LQNode<>(null);
        this.rear = this.front;
    }

    //  入队列
    public boolean enQueue(E e){
        LQNode<E> en = new LQNode<>(e);
        rear.next = en;
        rear = en;
        return true;
    }

    //  出队列
    public E deQueue(){
        if(rear == front){
            return null;
        }
        LQNode<E> temp = front.next;
        //  如果队列只剩一个结点，将rear指向front
        if(temp == rear){
            rear = front;
        }
        front.next = front.next.next;
        return temp.data;
    }

    //  遍历
    public void list(){
        if(front == rear){
            System.out.println("队列空");
        }
        LQNode<E> temp = front.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//  结点
class LQNode<E>{
    public E data;
    public LQNode<E> next;

    public LQNode(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LQNode{" +
                "data=" + data +
                '}';
    }
}
