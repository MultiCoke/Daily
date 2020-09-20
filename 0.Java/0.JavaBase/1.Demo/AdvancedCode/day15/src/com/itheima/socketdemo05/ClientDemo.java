package com.itheima.socketdemo05;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            new Thread(() ->{
                try {
                    client();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 11111);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day15\\1.png"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int b;
        while((b = bis.read()) != -1){
            bos.write(b);
        }
        bos.flush();
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }

        bis.close();
        socket.close();
    }
}