package com.itheima.demo04;

public class Girl extends Student implements Compere {
    @Override
    public void manager() {
        System.out.println("女士们，先生们，大家好，我是主持人...");
    }

    @Override
    public void eat() {
        System.out.println("我是女同学，我磕瓜子，吃水果...");
    }
}
