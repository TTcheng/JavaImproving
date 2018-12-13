package com.java8.datetime;

import org.junit.Test;

import java.time.LocalDateTime;

public class TestLocalDataTime {
    @Test
    public void testLocalDataTime() {
        //localDate LocalTime LocalDateTime使用方法一模一样，这里使用LocalDateTime举例
        //1、创建对象
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ldt = LocalDateTime.of(2005, 10, 1, 13, 12, 11);
        //2、获取时间
        System.out.println("now = " + now);
        System.out.println("year = " + now.getYear());
        System.out.println("month = " + now.getMonthValue());
        System.out.println("dayOfMonth = " + now.getDayOfMonth());
        System.out.println("hour = " + now.getHour());
        System.out.println("minute = " + now.getMinute());
        System.out.println("second = " + now.getSecond());
        //3、日期操作
        LocalDateTime tenYearsAgo = now.minusYears(10);
        System.out.println("tenYearsAgo = " + tenYearsAgo);
        LocalDateTime twoWeeksInFuture = now.plusWeeks(2);
        System.out.println("twoWeeksInFuture = " + twoWeeksInFuture);
    }
}