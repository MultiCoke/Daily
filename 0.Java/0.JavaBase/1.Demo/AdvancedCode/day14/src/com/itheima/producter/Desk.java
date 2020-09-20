package com.itheima.producter;

public class Desk {
    public boolean flag; // 是否有汉堡标记
    public int count; // 汉堡包的总数量
    public final Object lock = new Object(); // 锁对象

    public Desk() {
        this(false, 10);
    }

    public Desk(boolean flag, int count){
        this.flag = flag;
        this.count = count;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "flag=" + flag +
                ", count=" + count +
                ", lock=" + lock +
                '}';
    }
}