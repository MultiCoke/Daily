package com.itheima.demo02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    /*
    编写UDP程序
    发送端键盘输入内容,输入一行,发送到接收
    如果键盘输入的是 over 就结束发送
    接收端接收输入,将接收到的内容转成大写输出到控制台
    如果接收到over,就输出程序结束了
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = null;
        Socket socket = new Socket("127.0.0.1", 10001);

        while(true){
            String s = sc.next();
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(s);
            bw.newLine();
            bw.flush();
            if("over".equals(s)){
                break;
            }
        }

        bw.close();
        socket.close();
    }
}