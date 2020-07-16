package com.datastructures.list;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        caesar(3);
    }

    //  凯撒密码
    public static void caesar(int n){
        if(Math.abs(n) > 26){
            return;
        }

        DoubleLinkedList<Character> dll = new DoubleLinkedList<>();
        for (int i = 0; i < 26; i++) {
            dll.add((char)('A' + i));
        }
        dll.list();
        System.out.println(dll.getLength());

        //  指针后移n位，打印字母
        DulNode<Character> temp = dll.getHead().next;
        for (int i = 0; i <=26 ; i++) {
            temp = temp.next;
        }
        for (int i = 0; i <= 26; i++) {
            if(temp.e != null){
                System.out.print(temp.e);
            }
            temp = temp.next;
        }

    }
}



//  双向链表
class DoubleLinkedList<E>{
    private DulNode<E> head;

    public DoubleLinkedList() {
        this.head = new DulNode<>(null);
        head.next = head;
        head.prior = head;
    }

    public DulNode<E> getHead() {
        return head;
    }

    //  插入节点
    public boolean insert(E e, int i){
        if(i <= 0){
            return false;
        }

        DulNode<E> temp = head;
        int j = 1;
        while(temp.next != head){
            if(i == j){
                DulNode<E> insertN = new DulNode<>(e);
                insertN.next = temp.next;
                insertN.prior = temp;
                temp.next = insertN;
                insertN.next.prior = insertN;
                return true;
            }
            temp = temp.next;
            j++;
        }
        return false;
    }

    //  添加节点
    public void add(E e){
        DulNode<E> addN = new DulNode<>(e);
        DulNode<E> temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        addN.next = temp.next;
        addN.next.prior = addN;
        temp.next = addN;
        addN.prior = head;
    }

    //  删除节点
    public boolean delete(int i){
        if(i <= 0){
            return false;
        }

        DulNode<E> temp  = head;
        int j = 0;
        while(temp.next != head){
            if(i == j){
                temp.prior.next = temp.next;
                temp.next.prior = temp.prior;
                return true;
            }
            temp = temp.next;
            j++;
        }
        return false;
    }


    //  获取有效节点个数
    public int getLength(){
        int length = 0;
        DulNode<E> temp = head.next;
        while(temp != head){
            length++;
            temp = temp.next;
        }
        return length;
    }

    //  遍历
    public void list(){
        DulNode<E> temp = head.next;
        while(temp != head){
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//  双向链表节点
class DulNode<E>{
    public E e;
    public DulNode<E> prior;    //  前驱指针
    public DulNode<E> next;     //  后继指针

    public DulNode(E e) {
        this.e = e;
        this.prior = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "DulNode{" +
                "e=" + e +
                '}';
    }
}