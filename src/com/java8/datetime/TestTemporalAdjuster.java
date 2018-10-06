package com.java8.datetime;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Wangchuncheng on 2018/8/21 9:33
 */
public class TestTemporalAdjuster {
    @Test
    public void test() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextSaturday = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("nextSaturday = " + nextSaturday);

        //自定义下一个工作日
        LocalDateTime nextWeekDay = now.with(t -> {
            LocalDateTime dateTime = (LocalDateTime) t;
            if (dateTime.equals(DayOfWeek.FRIDAY)) {
                return dateTime.plusDays(3);
            } else if (dateTime.equals(DayOfWeek.SATURDAY)) {
                return dateTime.plusDays(2);
            } else return dateTime.plusDays(1);
        });
        System.out.println("nextWeekDay = " + nextWeekDay);

    }
}
