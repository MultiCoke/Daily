package com.datastructures.list;


public class SingleLinkedListDemo  {
    public static void main(String[] args) {
        SingleLinkedList<Integer> sll = new SingleLinkedList<>();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);
        sll.add(6);
        sll.add(7);
        sll.add(8);
        sll.add(9);
        sll.add(10);
        sll.insert(22,4);
        sll.list();

        SingleLinkedListDemo demo = new SingleLinkedListDemo();
        System.out.println(demo.getMid(sll));
        System.out.println(sll.length());
    }

    //  快速查找中间节点
    public Object getMid(SingleLinkedList l){
        if(l.getHead().next == null){
            return null;
        }
        Node slow = l.getHead().next;
        Node fast = l.getHead().next;
        while(fast.next != null){
            if(fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }else{
                fast = fast.next;
            }
        }
        return slow;
    }

}

//  单链表
class SingleLinkedList<E>{
    //  头节点
    private Node<E> head;
    private int length;

    //  创建一个单链表
    public SingleLinkedList() {
        this.head = new Node<E>(null);
        this.length = 0;
    }

    //  获取头节点
    public Node<E> getHead(){
        return this.head;
    }

    //  获取链表长度
    public int length(){
        return this.length;
    }

    //  单链表的遍历
    public void list(){
        Node<E> temp = head.next;
        while(temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //  添加节点
    public void add(E e){
        Node<E> addE = new Node<>(e);
        Node<E> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = addE;
        length++;
    }

    //  删除节点
    public boolean delete(int i){
        if(i <= 0 || i > length){
            return false;
        }
        Node<E> temp = head;
        int j = 1;
        while(temp.next != null){
            if(j == i){
                temp.next = temp.next.next;
                length--;
                return true;
            }
            temp = temp.next;
            j++;
        }
        return false;
    }

    //  获取单链表中指定位置的节点信息
    public Node<E> getElem(Node<E> head, int i){
        if(i <= 0 || i > length){
            return null;
        }
        Node<E> temp = head;
        int j = 1;
        //  遍历节点信息
        while(temp.next != null){
            if(j == i){
                return temp;
            }
            temp = temp.next;
            j++;
        }
        return null;
    }

    //单链表的插入
    public boolean insert(E e, int i){
        if(i <=0 || i > length){
            return false;
        }
        Node<E> temp = head;
        int j = 1;
        while(temp.next != null){
            if(i == j){
                Node<E> eInsert = new Node<E>(e);
                eInsert.next = temp.next;
                temp.next = eInsert;
                length++;
                return true;
            }else{
                temp = temp.next;
                j++;
            }
        }
        return false;
    }

    //单链表的整表删除
    public void free(){
        if(length == 0){
            return;
        }

        Node<E> temp = head.next;
        Node<E> free = null;
        while(temp != null ){
            if(temp.next != null){
                free = temp;
                temp = temp.next;
                free = null;
            }else{
                temp = null;
            }
        }
    }
}

//  节点
class Node<E>{
    public E e; //  数据域
    public Node<E> next; //    下一节点指针

    public Node(E e) {
        this.e = e;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e + "}";
    }
}