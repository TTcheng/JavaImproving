package com.wangchuncheng.enumeration;

/**
 * Created by Wangchuncheng on 2018/8/8 9:14
 * JDK 1.5 之前需要设计枚举类，而之后可以使用enum来声明一个枚举类
 */

/**
 * 不使用enum关键字设计枚举类
 */
public class Season {
    //1.提供类的属性，声明为private final
    private final String seasonName;
    private final String seasonDesc;
    //2.在构造器初始化
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4.创建枚举类对象
    public static final Season SPRING = new Season("Spring","春暖花开");
    public static final Season SUMMER = new Season("Summer","夏日炎炎");
    public static final Season AUTUMN = new Season("Autumn","秋高气爽");
    public static final Season WINTER = new Season("Winter","白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }

    //3.通过公共方法来调用
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
