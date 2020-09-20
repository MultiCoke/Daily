package com.itheima.socketdemo02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        String s;
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;

        while(true){
            s = sc.next();
            if("886".equals(s)){
                break;
            }
            DatagramPacket dp = new DatagramPacket(s.getBytes(), s.length(), address, port);
            socket.send(dp);
        }

        socket.close();
    }
}