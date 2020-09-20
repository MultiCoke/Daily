package com.itheima.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.14.91");
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
