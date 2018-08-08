package com.java8.lambda;

import com.java.entity.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Wangchuncheng on 2018/8/8 16:56
 */
public class AnonymousInnerClass {
    public Comparator<Person> oldImpl() {
        return new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
    }

    public Comparator<Person> newImpl() {
        return (x, y) -> Integer.compare(x.getAge(), y.getAge());
//        return Comparator.comparingInt(Person::getAge);
    }

    @Test
    public void test() {
//        TreeSet<Person> set = new TreeSet<>(oldImpl());
        TreeSet<Person> set = new TreeSet<>(newImpl());
        set.add(new Person("Jesse", 18));
        set.add(new Person("Jessie", 20));
        set.add(new Person("Jessica", 19));
        set.forEach(System.out::println);
//        for (Person person : set) {
//            System.out.println(person);
//        }
    }
}
