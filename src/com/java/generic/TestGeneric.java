package com.java.generic;

import com.java.entity.Dog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wangchuncheng on 2018/8/3 13:54
 * 使用泛型相对于不使用泛型，主要是解决类型安全的问题，比如List的泛型与非泛型实现
 */
public class TestGeneric {
    //泛型方法
    private <F> List<F> toList(F[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    @Test
    public void testGenericClass() {
        Person<Dog> person = new Person<>("Jesse", 31);
        Dog dog = new Dog("Xiaohua");
        person.setProperty(dog);
        System.out.println("person = " + person);
    }

    @Test
    public void testGenericMethod() {
        String[] names = new String[]{"Jesse","Jessie","Jessica"};
        Integer[] nums = new Integer[]{1,2,3};

        List nameList = toList(names);
        List numList = toList(nums);
        System.out.println("names = " + Arrays.toString(names));
        System.out.println("nums = " + Arrays.toString(nums));
        System.out.println("nameList = " + nameList);
        System.out.println("numList = " + numList);
    }
}

/**
 * 泛型类，泛型接口和它类似
 *
 * @param <T>不确定的属性
 */
class Person<T> {
    private String name;
    private Integer age;
    private T property;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public T getProperty() {
        return property;
    }

    public void setProperty(T property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "GenericClass{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", property=" + property +
                '}';
    }
}
