package com.itheima.threaddemo;

public class Demo04 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable{
    private static int tickets = 100;

    @Override
    public void run() {
        while(true){
            if(tickets <= 0){
                break;
            }
            sale();
        }
    }

    public static synchronized void sale(){
        if(tickets > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tickets--;
            System.out.println(Thread.currentThread().getName() + ": " + tickets);
        }
    }
}
