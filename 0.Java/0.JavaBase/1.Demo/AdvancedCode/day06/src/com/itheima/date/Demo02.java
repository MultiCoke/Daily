package com.itheima.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo02 {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

        String s = "2020-11-11";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf2.parse(s);
        System.out.println(parse);
    }
}
