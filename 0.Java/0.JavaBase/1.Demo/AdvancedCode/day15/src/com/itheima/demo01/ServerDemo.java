package com.itheima.demo01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10001);
        byte[] bytes = new byte[1024];

        while(true){
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            socket.receive(dp);
            System.out.println(new String(bytes, 0, dp.getLength()).toUpperCase());
            if("over".equals(new String(bytes, 0, dp.getLength()))){
                break;
            }
        }

        socket.close();
    }
}
