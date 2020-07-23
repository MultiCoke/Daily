package com.datastructures.list;

public class SqListDemo {
    public static void main(String[] args) {
        SqList<Integer> test = new SqList<>(5);
        test.add(1);
        test.add(2);
        test.add(3);
        test.delete(1);
        test.insert(0,5);
        test.add(4);
        test.add(6);
        Integer elem = test.getElem(1);
        test.list();
        System.out.println(test.getElem(1));
    }
}


//定义一个线性顺序存储数据类型
class SqList<E>{
    /*封装元素
      1.顺序表元素集合
      2.顺序表长度*/
    private Object[] obj;
    private int maxSize;
    private int length;

    //  构造一个顺序表
    public SqList(int maxSize) {
        this.obj = new Object[maxSize];
        this.length = 0;
        this.maxSize = maxSize;
    }

    //  判断线性表是否为空
    public boolean isEmpty(){
        return length == 0;
    }

    //  将线性表清空
    public void clearList(){
        for (int i = 0; i < length; i++) {
            obj[i] = null;
        }
    }

    //  返回指定位置的元素
    public E getElem(int i){
        if(i > length || i <= 0){
            return null;
        }
        return (E)obj[i-1];
    }

    //  在表最后添加元素
    public int add(E e){
        if(length == maxSize){
            return -1;
        }
        obj[length] = e;
        length++;
        return 1;
    }

    //  插入操作--插入指定位置
    public int insert(E e,int i){
        //如果插入数组已满，或插入位置不在数组索引范围内，返回-1
        if(length == maxSize || i > maxSize || i <= 0){
            return -1;
        }
        //如果插入位置大于数组的长度，在数组末端插入
        if(i > length){
            return add(e);
        }
        for (int j = i - 1; j < obj.length - 1; j++) {
            obj[j] = obj[j+1];
        }
        obj[i - 1] = e;
        length++;
        return 1;
    }

    //删除元素
    public int delete(int i){
        if(length == 0 || i > length || i < 0){
            return -1;
        }
        for (int j = i -1; j < obj.length - 1; j++) {
            obj[j] = obj[j + 1];
        }
        length--;
        return 1;
    }

    //遍历表
    public void list(){
        for (int i = 0; i < obj.length; i++) {
            System.out.println(obj[i]);
        }
    }
}