package com.itheima.demo03;

public class Cat extends Animal {
    @Override
    public void shut() {
        System.out.println("小猫喵喵叫...");
    }

    public void catchMouse(){
        System.out.println("小猫抓老鼠");
    }
}
