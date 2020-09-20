package com.itheima.socketdemo04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10111);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();
        int b;
        while((b = is.read()) != -1){
            System.out.print((char)b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("world");
        bw.newLine();
        bw.flush();

        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}