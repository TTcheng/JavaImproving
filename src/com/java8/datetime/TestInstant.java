package com.java8.datetime;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Created by Wangchuncheng on 2018/8/21 9:00
 */
public class TestInstant {
    @Test
    public void test() {
        Instant now = Instant.now();
        System.out.println("now = " + now);
        OffsetDateTime localNow = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println("localNow = " + localNow);
        System.out.println("now millis = " + now.toEpochMilli());
    }
}
