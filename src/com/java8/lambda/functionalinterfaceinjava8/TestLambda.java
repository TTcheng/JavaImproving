package com.java8.lambda.functionalinterfaceinjava8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Wangchuncheng on 2018/8/13 15:36
 *
 * Java8 内置四大核心函数式接口
 *
 * Consumer<T> : 消费型接口
 *      void accept(T t)
 *
 * Supplier<T> : 供给型接口
 *      T get()
 *
 * Function<T,R> : 函数型接口
 *      R apply(T t)
 *
 * Predicate<T> : 断言型接口
 *      Boolean test(T t)
 */
public class TestLambda {
    @Test
    public void testConsumer(){
        happy(1000.0,(m)-> System.out.println("此次消费" + m + "元"));
    }

    public void happy(Double monony, Consumer<Double> consumer){
        consumer.accept(monony);
    }

    @Test
    public void testSupplier() {
        List list = getNumList(10, () -> (int) (Math.random() * 100));
        System.out.println("list = " + list);
    }

    //产生指定个数的整数，并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    @Test
    public void testFunction(){
        String oldStr = "\t\t\t 牛逼";
        System.out.println("oldStr = " + oldStr);
        String newStr = strHandler(oldStr,s -> s.trim());
        System.out.println("newStr = " + newStr);
    }

    //用于处理字符串
    public String strHandler(String s, Function<String, String> function) {
        return function.apply(s);
    }

    @Test
    public void testPredicate() {
        List<String> oldList = new ArrayList<>();
        oldList.add("Jesse");
        oldList.add("Tom");
        oldList.add("Hello");
        List newList = filterStr(oldList, s -> s.length() > 3);
        System.out.println("oldList = " + oldList);//Jesse tom hello
        System.out.println("newList = " + newList);//Jesse Hello
    }

    //过滤字符串
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        List<String> strlist = new ArrayList<String>();
        for (String s : list) {
            if (predicate.test(s)) {
                strlist.add(s);
            }
        }
        return strlist;
    }

}
