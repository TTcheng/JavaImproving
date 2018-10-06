package com.java8.datetime;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Created by Wangchuncheng on 2018/8/21 9:50
 */
public class TestTimeZone {
    //ZoneDate ZoneTime ZoneDateTime
    @Test
    public void testZone() {
        //打印支持的时区
        Set<String> zoneSet = ZoneId.getAvailableZoneIds();
        zoneSet.forEach(System.out::println);
        //东京时间
        LocalDateTime tokyoTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("tokyoTime = " + tokyoTime);
        //2018-08-21T10:00:08.992+08:00[Asia/Shanghai]
        ZonedDateTime zoneNow = ZonedDateTime.now();
        System.out.println("zoneNow = " + zoneNow);
    }
}
