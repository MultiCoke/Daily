package com.itheima.charstream;

import java.io.*;

public class Demo08 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User("zhangsan", "qwer");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        oos.writeObject(user);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        Object obj = ois.readObject();
        ois.close();
        User u = (User) obj;
        System.out.println(u);
    }
}
