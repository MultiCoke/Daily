package com.datastructures.list;

public class CycleLinkedListDemo {
    public static void main(String[] args) {
        latin(9);
    }

    //  约瑟夫问题
    public static void anwer(){
        //  创建一个循环链表对象
        CycleLinkedList<Integer> cll = new CycleLinkedList<>();

        //  添加41个节点
        for (int i = 1; i <= 41 ; i++) {
            cll.add(i);
        }

        //  定义两个指针，用于删除元素
        Node<Integer> tempF = cll.getRear().next;
        Node<Integer> tempR = cll.getRear();

        //  前指针负责找到删除元素，后指针保存下一节点数据并将节点信息赋值给删除后的前指针
        //  循环41次，删除所有元素
        int i = 1;
        while(i <= 41){
            tempF = tempF.next.next;
            System.out.println(tempF.e);
            tempR = tempR.next.next;
            tempR.next = tempF.next;
            tempF = tempR.next;
            i++;
        }
    }

    //  魔术师发牌问题
    public static void magicPaker(){
        //  创建一个循环链表对象
        CycleLinkedList<Integer> cll = new CycleLinkedList<>();

        //  添加13个节点
        for (int i = 0; i < 13 ; i++) {
            cll.add(0);
        }

        //  向链表添加数据，每隔number个更新节点
        Node<Integer> temp = cll.getRear().next;
        temp.e = 1;
        int number = 2;
        while(true){
            for(int j = 0; j < number; j++){
                temp = temp.next;
                if(temp.e != 0){
                    j--;
                }
            }

            if(temp.e == 0){
                temp.e = number;
                number++;

                if(number == 14){
                    break;
                }
            }
        }

        //  打印结果
        cll.list();
    }

    //  拉丁方阵
    public static void latin(int n){
        //  生成n个连续元素的循环链表
        CycleLinkedList<Integer> cll = new CycleLinkedList<>();
        for (int i = 1; i <= n; i++) {
            cll.add(i);
        }

        //  打印节点，共打印n行，每打印一次，开始指针往后移一位
        Node<Integer> temp = cll.getRear().next;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp.e + "  ");
                temp = temp.next;
            }
            temp = temp.next;
            System.out.println();
        }
    }
}


//  循环链表
class CycleLinkedList<E>{
    private Node<E> rear;
    private int length;

    public CycleLinkedList() {
        this.rear = null;
    }

    //  获取尾指针
    public Node<E> getRear() {
        return rear;
    }

    //  获取指定节点
    public Node<E> getElem(int i){
        if(i <= 0){
            return null;
        }
        Node<E> temp = rear.next;
        int j = 1;
        while(temp.next != null){
            if(i == j){
                return temp.next;
            }
            temp = temp.next;
            j++;
        }
        return null;
    }

    //  获取链表长度
    public int getLength(){
        return length;
    }

    //  插入节点
    public boolean insert(E e, int i){
        if(i <= 0 ){
            return false;
        }
        Node<E> temp = rear.next;
        int j = 1;
        while(temp.next != null){
            if(i == j){
                Node<E> insertN = new Node<>(e);
                insertN.next = temp.next;
                temp.next = insertN;
                length++;
                return true;
            }
            temp = temp.next;
            j++;
        }
        return false;
    }

    //  删除节点
    public boolean delete(int i){
        if(i <= 0 ){
            return false;
        }
        Node<E> temp = rear.next;
        int j = 1;
        while(temp.next != null){
            if(i == j){
                temp.next = temp.next.next;
                length--;
                return true;
            }
            temp = temp.next;
            j++;
        }
        return false;
    }

    //  添加节点
    public void add(E e){
        if(rear == null){
            rear = new Node<>(e);
            rear.next = rear;
            return;
        }
        Node<E> addN = new Node<>(e);
        addN.next = rear.next;
        rear.next = addN;
        rear = addN;
        length++;
    }

    //  遍历链表
    public void list(){
        Node<E> temp = rear.next;
        while(temp!= rear){
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println(temp);
    }
}

//  节点
class NodeC<E>{
    public E e; //  数据域
    public NodeC<E> next; //    下一节点指针

    public NodeC(E e) {
        this.e = e;
        next = null;
    }

    @Override
    public String toString() {
        return "NodeC{" +
                "e=" + e + "}";
    }
}