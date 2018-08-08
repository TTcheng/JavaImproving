package com.java.annotation;

/**
 * Created by Wangchuncheng on 2018/8/8 9:49
 */

import org.junit.Test;

import java.util.Date;

/**
 * JDK 1.5 开始增加了注解，提供了对元数据的支持
 * 1、三个基本注解：
 *
 * @Override 重写方法
 * @Deprecated API已过时
 * @SuppressWarnings 抑制编译器警告
 * <p>
 * 2、自定义注解
 * @interface MyAnnotation{}
 * 3、元注解
 * @Retention
 * @Target
 * @Documented
 * @Inherited
 */
public class TestAnnotation {
    @Test
    public void testBasicAnnotation() {
        this.toString();
        this.deprecatedMethod();
        this.printDate();
    }

    public void testMyAnnotation() {
        @MyAnnotation("Anyway")
        String name;
    }

    @Override
    public String toString() {
        return "重写的toString";
    }

    @Deprecated
    public void deprecatedMethod() {
        //抑制编译器的unused警告
        @SuppressWarnings({"unused"})
        String var;
        System.out.println("这是过时的方法");
    }

    public void printDate() {
        Date date = new Date();
        System.out.println("date = " + date);
    }
}
