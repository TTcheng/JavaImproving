package com.wangchuncheng.enumeration;

/**
 * Created by Wangchuncheng on 2018/8/8 9:28
 */

/**
 * 1、使用enum关键字定义枚举
 * 2、几个常用方法values(),valueOf()
 * 3、如何实现接口
 */
public enum Season1 implements Info{
    SPRING("Spring", "春暖花开"){
        /**
         * 各自实现不同的接口方法
         */
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("Summer", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("生如夏花");
        }
    },
    AUTUMN("Autumn", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天是分手的季节");
        }
    },
    WINTER("Winter", "白雪皑皑"){
        @Override
        public void show() {
            System.out.println("冬天里的一把火");
        }
    };

    private final String name;
    private final String desc;

    Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //统一实现
//    @Override
//    public void show() {
//        System.out.println("四季如春");
//    }

    @Override
    public String toString() {
        return "Season1{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
