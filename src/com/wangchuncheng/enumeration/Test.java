package com.wangchuncheng.enumeration;

/**
 * Created by Wangchuncheng on 2018/8/8 9:24
 */
public class Test {
    //测试自定义的枚举类
    @org.junit.Test
    public void testSeason() {
        Season spring = Season.SPRING;
        System.out.println(spring);
    }

    //测试enum的枚举类
    @org.junit.Test
    public void testSeason1() {
        Season1[] seasons = Season1.values();
        for (Season1 season1 : seasons) {
            System.out.println(season1);
            season1.show();
        }
    }
}
