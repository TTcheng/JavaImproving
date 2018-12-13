package com.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda {
    // 使用lambda的例子
    @Test
    public void test() {
        Integer num;
        num = operation(10, (x) -> x * x);//平方运算
        System.out.println(num);
        num = operation(10, (x) -> x * x * x);//立方运算
        System.out.println(num);
    }

    @FunctionalInterface
    interface Operational {
        public Integer operate(Integer num);
    }

    public Integer operation(Integer num, Operational mf) {
        return mf.operate(num);
    }


    @Test
    public void testParam() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello lambda!");
    }

    @Test
    public void testReturnValue() {
        /*Comparator<Integer> c = (x, y) -> {
            System.out.println("函数式接口");
            return x - y;
        };*/
        Comparator<Integer> c = (x,y) -> x-y;
        Integer result = c.compare(1, 2);
        System.out.println(result);
    }
}
