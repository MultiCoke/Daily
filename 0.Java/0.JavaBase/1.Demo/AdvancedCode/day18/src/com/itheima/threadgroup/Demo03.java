package com.itheima.threadgroup;

public class Demo03 {
    public static void main(String[] args) {
        // 线程组统一异常处理
        ThreadGroup group1 = new ThreadGroup("group1"){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        // 添加一个线程到线程组
        new Thread(group1, () -> {
            throw new RuntimeException("测试异常");
        }).start();
    }
}