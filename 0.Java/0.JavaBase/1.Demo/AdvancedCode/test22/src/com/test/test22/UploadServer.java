package com.test.test22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UploadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);
        ExecutorService pool = Executors.newCachedThreadPool();

        Socket accept = ss.accept();
        pool.submit(() -> {
            // 接收图片
            BufferedInputStream bis = null;
            try {
                bis = new BufferedInputStream(accept.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedOutputStream bos = null;
            try {
                bos = new BufferedOutputStream(new FileOutputStream("test22\\copy.png"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            byte[] bytes = new byte[1024];
            int len;

            if(bis != null && bos != null){
                try {
                    while((len = bis.read(bytes)) != -1){
                        bos.write(bytes, 0, len);
                    }
                    bos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            // 服务器反馈
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bw.write("服务器的反馈：文件上传成功");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(bw != null){
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            // 关流
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}