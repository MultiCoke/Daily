package com.itheima.demo03;

public class Person {
    public void playWithAnimal(Animal animal){
        animal.shut();

        if (animal instanceof Cat){
            ((Cat) animal).catchMouse();
        }
    }
}
