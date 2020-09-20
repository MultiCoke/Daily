package com.itheima.annodemo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ServletAnno {
    String className();
    String methodName();
}
