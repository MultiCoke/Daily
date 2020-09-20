package com.itheima.socketdemo01;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建socket
        DatagramSocket socket = new DatagramSocket();

        // 2.打包数据
        BufferedOutputStream picture = new BufferedOutputStream(new FileOutputStream("a.jpg"));

        byte[] bytes = "Hello World".getBytes();
        int port = 10000;
        InetAddress ad = InetAddress.getByName("192.168.14.209");
        DatagramPacket data = new DatagramPacket(bytes, bytes.length, ad, port);

        // 3.发送数据
        socket.send(data);

        // 4.关闭资源
        socket.close();
    }
}