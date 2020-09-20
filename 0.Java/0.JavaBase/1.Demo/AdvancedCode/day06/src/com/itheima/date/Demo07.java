package com.itheima.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Demo07 {
    public static void main(String[] args) {
        // 间隔日期对象
        LocalDate localDate1 = LocalDate.of(2020, 11, 11);
        LocalDate localDate2 = LocalDate.of(2021, 12, 11);

        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.toTotalMonths());
    }
}
