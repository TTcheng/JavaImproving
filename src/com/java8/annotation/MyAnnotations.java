package com.java8.annotation;

import java.lang.annotation.*;

/**
 * Created by Wangchuncheng on 2018/8/21 10:05
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations {
    MyAnnotation[] value();
}
