package com.java8.datetime;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by Wangchuncheng on 2018/8/21 9:09
 */
public class TestDateTimeTools {
    @Test
    public void testPeriod() {
        LocalDate now = LocalDate.now();
        LocalDate aWeekLater = now.plusWeeks(1);
        Period period = Period.between(now, aWeekLater);
        System.out.println("period = " + period.getDays());
    }

    @Test
    public void testDuration() {
        Instant now = Instant.now();
        Instant twoMinutesLater = Instant.now().plusSeconds(120);
        Duration duration = Duration.between(now, twoMinutesLater);
        System.out.println("duration = " + duration.getSeconds());
        System.out.println("millis between = " + duration.toMillis());
    }

    @Test
    public void testFormatter() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        String formatted = now.format(dtf);
        System.out.println("formatted = " + formatted);

        DateTimeFormatter myPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("formatted = " + now.format(myPattern));
    }
}
