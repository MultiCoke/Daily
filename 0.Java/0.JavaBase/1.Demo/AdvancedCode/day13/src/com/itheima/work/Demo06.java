package com.itheima.work;

public class Demo06 {
    /*
    有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。
    请用线程进行模拟并设置线程名称用来代表售出途径，再将信息打印出来
     */
    public static void main(String[] args) {
        SaleCup sc = new SaleCup();
        Thread t1 = new Thread(sc);
        t1.setName("实体店");
        Thread t2 = new Thread(sc);
        t2.setName("官网");

        t1.start();
        t2.start();
    }
}

class SaleCup implements Runnable{
    private static int cupNumber = 100;

    @Override
    public void run() {
        while(true){
            if(cupNumber <= 0){
                break;
            }
            sale();
        }

    }

    public static synchronized void sale(){
        if(cupNumber > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cupNumber--;
            System.out.println(Thread.currentThread().getName() + "卖了一个杯子，还剩" + cupNumber + "个");
        }
    }
}
