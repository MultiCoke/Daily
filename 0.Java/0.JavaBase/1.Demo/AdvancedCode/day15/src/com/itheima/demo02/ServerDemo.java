package com.itheima.demo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);
        Socket accept = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String s;
        while((s = br.readLine()) != null){
            System.out.println(s.toUpperCase());
            if("over".equals(s)){
                break;
            }
        }

        br.close();
        accept.close();
        ss.close();
    }
}