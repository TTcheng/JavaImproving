package com.java8.lambda.practice;

/**
 * Created by Wangchuncheng on 2018/8/13 15:14
 */
public interface Operational<T,R> {
    R operate(T t1,T t2);
}
