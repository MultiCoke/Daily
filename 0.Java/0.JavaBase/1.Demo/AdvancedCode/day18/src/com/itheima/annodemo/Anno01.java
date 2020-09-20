package com.itheima.annodemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface Anno01 {
    int show1();
    String show2();
}