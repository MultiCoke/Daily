package com.itheima.socketdemo05;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable {
    private Socket accept;

    public ThreadSocket(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        BufferedOutputStream bos = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            String name = UUID.randomUUID().toString();
            bos = new BufferedOutputStream(new FileOutputStream("day15\\copy\\" + name + ".png"));

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
            bos.flush();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bw.write("load success " + name);
            bw.newLine();
            bw.flush();
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
