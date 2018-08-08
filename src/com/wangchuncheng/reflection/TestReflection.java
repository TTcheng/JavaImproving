package com.wangchuncheng.reflection;

import com.wangchuncheng.entity.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * Created by Wangchuncheng on 2018/8/8 10:42
 * 反射被视为是动态语音的关键
 * 1、理解Class类并实例化Class对象
 * 2、运行时创建对象并获得完整结构
 * 3、通过反射调用指定对象的方法和属性
 * 4、动态代理
 * 主要API
 * java.lang.Class
 * java.lang.reflect.Method -Field -Constructor
 * ...
 */
public class TestReflection {
    /**
     * 获取Class实例的几种方式
     */
    @Test
    public void testGetClass() throws ClassNotFoundException {
        Person person = new Person();
        Class aClass;
        //1、调用类本身的class属性
        aClass = Person.class;
        System.out.println(aClass.getName());

        //2、通过对象的getClass方法获取
        aClass = person.getClass();
        System.out.println(aClass.getName());

        //3、通过Class.forName()获取
        aClass = Class.forName("com.wangchuncheng.entity.Person");
        System.out.println(aClass.getName());

        //4、使用classLoader
        ClassLoader classLoader = this.getClass().getClassLoader();
        classLoader.loadClass("com.wangchuncheng.entity.Person");
        System.out.println(aClass.getName());
        /**
         * ClassLoader还能做什么？
         * 1、获取资源流，方便读取包下的文件
         *
         * InputStream is = loader.getResourceAsStream("com\\xxx\\xxx");
         * Properties props = new Properties();
         * props.load(is);
         * String name = props.getProperty("name");
         */
    }

    /**
     * 在运行时操作类的结构
     * ## 注意 1）运行时创建对象的类必须有无参构造方法。2）无参构造器的权限修饰符必须满足条件
     */
    @Test
    public void testReflection() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        /**
         * 创建对象
         */
        Class<Person> aClass = Person.class;
        Person person = aClass.newInstance();
        /**
         * 运行时操作属性
         */
        //1.保留封装性，通过反射获取属性，然后赋值.需要属性为public
        /*
        Field name = c.getField("name");
        name.set(person,"Jesse");
        */
        //2.无视封装性，获取属性赋值
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Jessie");
        person.sayHello();
        //3.调用对象方法赋值
        person.setAge(15);
        person.setName("Jesse");
        person.sayHello();

        /**
         * 运行时操作方法
         */
        Method setName = aClass.getMethod("setName", String.class);//获取有参方法
        setName.invoke(person, "Jessica");
        Method sayHello = aClass.getMethod("sayHello");//获取无参方法
        Object returnValue = sayHello.invoke(person);//执行
//        Object returnValue = method.invoke(Person.class,args);//执行静态方法

        /**
         * 获取构造器
         */
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
        }
        //执行指定构造器创建对象
        Constructor constructor = aClass.getDeclaredConstructor(String.class,Integer.class);
        Person tom = (Person) constructor.newInstance("Tom",21);
        System.out.println("tom = " + tom);

        /**
         * 获取其他结构
         */
        Class<? super Person> superclass = aClass.getSuperclass();//获取父类
        System.out.println("superclass = " + superclass);
        Type genericSuperclass = aClass.getGenericSuperclass();//带泛型的父类
        System.out.println("genericSuperclass = " + genericSuperclass);
        Class[] interfaces = aClass.getInterfaces();//接口
        for (Class c : interfaces) {
            System.out.println("c = " + c);
        }
        Package p = aClass.getPackage();//包
        System.out.println("package = " + p);
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
//        aClass.getModifiers();//访问域
    }
}
