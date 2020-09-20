package com.itheima.socketdemo03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 1.创建Socket对象
        Socket socket = new Socket("192.168.14.209", 11111);

        // 2.获取一个IO流开始写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello world".getBytes());

        // 3.释放资源
        os.close();
        socket.close();
    }
}
