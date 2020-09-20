package com.itheima.socketdemo05;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(11111);
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            Socket accept = ss.accept();
            pool.submit(new ThreadSocket(accept));
        }
    }
}
