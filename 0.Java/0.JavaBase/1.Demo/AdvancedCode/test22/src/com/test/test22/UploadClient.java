package com.test.test22;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UploadClient {
    /*
    需求：编写客户端和服务器端程序，客户端用于上传图片，服务器端用于接收文件，文件上传成功后，给客户端一个反馈：文件上传成功。
    注意：
    服务器端采用多线程实现，并且要解决文件名冲突问题
     */
        public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);
        Scanner sc = new Scanner(System.in);

        while (true){
            // 上传图片
            System.out.println("请输入上传文件的路径：");
            String path = sc.next();
            File file = new File(path);
            if(file.exists() && file.isFile()){
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

                byte[] bytes = new byte[1024];
                int len;

                while((len = bis.read(bytes)) != -1){
                    bos.write(bytes, 0, len);
                }
                bos.flush();
                socket.shutdownOutput();
                bis.close();
            }else{
                System.out.println("请输入正确的图片文件路径，请重新输入：");
                continue;
            }

            // 接收服务器的反馈
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
            socket.close();
            break;
        }
    }
}