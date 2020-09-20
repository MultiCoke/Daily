package com.itheima.homework;

import java.io.File;

public class Demo02 {
    /*
    定义类，定义main()方法，按以下要求编写代码：

  ​	构造一个File对象，指向你D盘的某个目录；​

  ​	获取此目录下所有的文件/目录的File对象，遍历这个数组，获取每个File对象

  ​	判断：如果是文件，打印：”文件(绝对路径)” 否则，打印：”目录(绝对路径)
     */
    public static void main(String[] args) {
        File file = new File("C:\\test");
        getFiles(file);
    }

    public static void getFiles(File file){
        File[] files = file.listFiles();
        System.out.println("目录(" + file.getAbsolutePath() + ")");

        for (File f : files) {
            if(f.isFile()){
                System.out.println("文件(" + f.getAbsolutePath() + ")");
            }else{
                getFiles(f);
            }
        }
    }
}
