package com.java8.lambda.methodreference;

import com.java.entity.Person;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by Wangchuncheng on 2018/8/13 16:25
 */
public class TestMethodReference {
    @Test
    public void test1() {
        //Consumer consumer = x -> System.out.println(x);
        Consumer consumer = System.out::println;
        consumer.accept("Hello lambda!");
        //构造器引用
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
    }
}
