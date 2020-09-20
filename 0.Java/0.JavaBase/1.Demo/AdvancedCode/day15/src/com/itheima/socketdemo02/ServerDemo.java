package com.itheima.socketdemo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(10000);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        while(true){
            socket.receive(dp);
            System.out.println(new String(bytes, 0, dp.getLength()));
        }
    }
}