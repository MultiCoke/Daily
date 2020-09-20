package com.itheima.demo01;

public class StartTest {
    public static void main(String[] args) {
        Start start = new StartSon();
        start.setName("ming");
        start.setAge(20);

        start.introduction();
        if(start instanceof StartSon){
            StartSon ss = (StartSon) start;
            ss.dance();
        }
    }
}
