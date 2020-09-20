package com.itheima.socketdemo04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10111);
        OutputStream os = socket.getOutputStream();
        os.write("Hello".getBytes());
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
        os.close();
        socket.close();
    }
}