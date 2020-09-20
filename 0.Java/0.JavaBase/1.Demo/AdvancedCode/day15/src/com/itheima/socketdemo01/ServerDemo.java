package com.itheima.socketdemo01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建接收端socket
        DatagramSocket socket = new DatagramSocket(10000);

        // 2.创建接受数据容器
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 3.接受数据
        socket.receive(dp);

        // 4.打印数据
        System.out.println(new String(bytes));

        // 5.释放资源
        socket.close();
    }
}
