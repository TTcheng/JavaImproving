package com.java8.annotation;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Wangchuncheng on 2018/8/21 10:11
 */
public class TestAnnotation {
    @MyAnnotation("Hello")
    @MyAnnotation("World")
    public void show(){}

    //通过反射获取我们的注解
    @Test
    public void test() throws NoSuchMethodException {
        Class<TestAnnotation> thisClass = TestAnnotation.class;
        Method show = thisClass.getMethod("show");

        MyAnnotation[] mas = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation ma : mas) {
            System.out.println("ma = " + ma.value());
        }
    }

    @Test
    public void testMyAnnonation(){
        Class<MyAnnotation> annotationClass = MyAnnotation.class;
        String annotationClassName = annotationClass.getName();
        System.out.println("annotationClassName = " + annotationClassName);

        Method[] methods = annotationClass.getMethods();
        Arrays.stream(methods).forEach((method)-> System.out.println(method.getName()));
    }
}
