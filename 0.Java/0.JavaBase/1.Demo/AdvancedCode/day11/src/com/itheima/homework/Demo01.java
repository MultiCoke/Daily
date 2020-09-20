package com.itheima.homework;

import java.io.File;
import java.io.IOException;

public class Demo01 {
    /*
    定义测试类，在测试类中定义main()方法，按以下要求编写代码：

  ​	构造一个File对象，指向项目根目录下的demo03.txt（此文件不存在）；

  ​	判断，如果文件不存在，就创建这个文件，打印创建结果；

  ​	判断这个File对象是否是一个文件，打印结果；

  ​	判断这个File对象是否是一个目录，打印结果；

  ​	删除这个文件
     */
    public static void main(String[] args) throws IOException {
        File file = new File("demo03.txt");
        if(!file.exists()){
            System.out.println(file.createNewFile());
        }

        if(file.isFile()){
            System.out.println("file is file");
        }else if(file.isDirectory()){
            System.out.println("file is directory");
        }

        file.delete();
    }
}
