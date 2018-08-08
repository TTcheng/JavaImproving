package com.java.entity;

import java.io.Serializable;

/**
 * Created by Wangchuncheng on 2018/8/3 14:04
 */
public class Person implements Comparable, Serializable {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello I'm " + name);
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getAge(), ((Person) o).getAge());
    }

    @Override
    public boolean equals(Object obj) {
        Person annother = (Person) obj;
        if (this.name.equals(annother.getName())) {
            return this.age.equals(annother.getAge());
        } else return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age.hashCode();
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
}
