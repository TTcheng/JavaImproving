package com.java8.lambda.practice;

import org.junit.Test;

/**
 * Created by Wangchuncheng on 2018/8/13 15:16
 */
public class TestLambda {
    Operational<Long, String> add = (x, y) -> "result = " + String.valueOf(x + y);
    Operational<Long, String> mutiply = (x, y) -> "result = " + String.valueOf(x * y);
    Operational<Long, String> divide = (x, y) -> "result = " + String.valueOf(x / y);
    Operational<Long, String> subtract = (x, y) -> "result = " + String.valueOf(x - y);

    @Test
    public void testOperations() {
        String result;
        result = add.operate(1l, 2l);
        System.out.println(result);
        result = subtract.operate(1l, 2l);
        System.out.println(result);
        result = mutiply.operate(1l, 2l);
        System.out.println(result);
        result = divide.operate(1l, 2l);
        System.out.println(result);
    }
}
