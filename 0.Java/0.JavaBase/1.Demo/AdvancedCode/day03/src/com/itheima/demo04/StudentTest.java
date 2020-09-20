package com.itheima.demo04;

public class StudentTest {
    public static void main(String[] args) {
        Student boy = new Boy();
        Compere girl = new Girl();

        ClassRoom cr = new ClassRoom();
        cr.play(girl, boy);
    }
}