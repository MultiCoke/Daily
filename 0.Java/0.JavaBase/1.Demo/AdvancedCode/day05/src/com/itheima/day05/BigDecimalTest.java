package com.itheima.day05;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("0.1");
        BigDecimal b2 = new BigDecimal("0.2");

        System.out.println(b1.add(b2));

        System.out.println(b1.subtract(b2));

        System.out.println(b1.multiply(b2));

        System.out.println(b1.divide(b2, 2, RoundingMode.HALF_UP));
    }
}
