package com.itheima.socketdemo02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServerDemo02 {
    public static void main(String[] args) throws IOException {
        MulticastSocket socket = new MulticastSocket(10000);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        socket.joinGroup(InetAddress.getByName("224.0.1.0"));
        socket.receive(dp);

        System.out.println(new String(bytes, 0, dp.getLength()));
    }
}