package com.itheima.classloder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 1.通过本类获取加载器，然后再获取流
        InputStream is1 = Demo01.class.getClassLoader().getResourceAsStream("prop.properties");

        // 2.通过当前线程获取类加载器
        InputStream is2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("prop.properties");

        // 3.获取系统类加载器
        InputStream is3 = ClassLoader.getSystemClassLoader().getResourceAsStream("prop.properties");

        // 4.直接使用类加载获取流
        InputStream is4 = ClassLoader.getSystemResourceAsStream("prop.properties");

        Properties prop = new Properties();
        prop.load(is4);

        System.out.println(prop);
    }
}