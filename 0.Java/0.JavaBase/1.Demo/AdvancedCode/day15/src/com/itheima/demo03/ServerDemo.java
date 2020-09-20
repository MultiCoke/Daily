package com.itheima.demo03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);
        Socket accept = ss.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
        String line;
        boolean flag = false;

        while (!flag) {
            while((line = br.readLine()) != null){
                if("download".equals(line)){
                    flag = true;
                }
            }
        }

        BufferedOutputStream bos = new BufferedOutputStream(accept.getOutputStream());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day15\\1.png"));
        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.flush();

        bis.close();
        accept.close();
        ss.close();
    }
}