package com.itheima.demo01;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDemo {
    /*
    实现UDP程序
    客户端键盘录入数据发送给服务器端,录入一行发一次
    服务器接收到客户端数据后,将数据转成大写回给客户端
    客户端读取服务器发回的大写数据
    如果客户端录入 over 就停止程序
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while(true){
            String next = sc.next();
            DatagramPacket dp = new DatagramPacket(next.getBytes(), next.getBytes().length, InetAddress.getByName("127.0.0.1"), 10001);
            socket.send(dp);
            if("over".equals(next)){
                break;
            }
        }

        socket.close();
    }
}