package com.itheima.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Demo03 {
    public static void main(String[] args) throws ParseException {
        String start = "2020-11-11 00:00:00";
        String end = "2020-11-11 00:10:00";
        String jia = "2020-11-11 00:03:00";
        String pi = "2020-11-11 00:11:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long startTime = sdf.parse(start).getTime();
        long endTime = sdf.parse(end).getTime();
        long jiaTime = sdf.parse(jia).getTime();
        long piTime = sdf.parse(pi).getTime();

        if (jiaTime >= startTime && jiaTime <= endTime) {
            System.out.println("jia was take in this second kill");
        } else {
            System.out.println("jia wasn't take in this second kill");
        }

        if (piTime >= startTime && piTime <= endTime) {
            System.out.println("pi was take in this second kill");
        } else {
            System.out.println("pi wasn't take in this second kill");
        }
    }
}
