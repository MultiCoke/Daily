package com.itheima.demo03;

public class AnimalTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Person person = new Person();

        person.playWithAnimal(cat);
        System.out.println("--------------");
        person.playWithAnimal(dog);
    }
}
