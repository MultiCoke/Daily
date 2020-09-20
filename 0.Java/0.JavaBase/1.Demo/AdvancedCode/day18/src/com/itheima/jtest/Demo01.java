package com.itheima.jtest;

import org.junit.Assert;
import org.junit.Test;

public class Demo01 {
    @Test
    public void add(){
        int sum = sum(1, 1);
        Assert.assertEquals(2, sum);
    }

    public int sum(int a, int b){
        return a + b;
    }
}