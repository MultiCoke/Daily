package com.itheima.demo02;

import java.util.Random;

public class RandomHandler {
    public static void main(String[] args) {
        useRandom(() -> {
            Random random = new Random();
            int result = random.nextInt(10) + 1;
            return result;
        });
    }

    public static void useRandom(RandomInter randomInter){
        int number = randomInter.getNumber();
        System.out.println(number);
    }
}

interface RandomInter{
    int getNumber();
}
