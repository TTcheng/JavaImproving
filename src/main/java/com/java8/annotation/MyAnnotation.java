package com.java8.annotation;

import java.lang.annotation.*;

/**
 * Created by Wangchuncheng on 2018/8/21 10:02
 */
//可重复注解需要容器注解
@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "hello";
}
