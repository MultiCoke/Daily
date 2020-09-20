package com.itheima.demo03;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    /*
    TCP文件下载
    客户端从服务器端下载图片
    服务器将1.jpg文件以流的形式写给客户端
    客户端从服务器读取文件,并保存到.jpg目录下
    保存成功后,控制台打印出下载完成
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("download");
        bw.newLine();
        bw.flush();
        socket.shutdownOutput();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day15\\2.png"));

        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.flush();

        System.out.println("下载成功");
        bos.close();
        socket.close();
    }
}