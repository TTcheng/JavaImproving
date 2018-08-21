package com.java8.streamapi;

import com.java.entity.Employee;
import com.java.entity.Person;
import com.java.entity.Status;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by Wangchuncheng on 2018/8/13 16:47
 * <p>
 * Stream的三个步骤：
 * 1、创建Stream : CollectionImpls.stream()/parallelStream()(并行流) 、Arrays.Stream()、Stream.of()、无限流stream.generate()/iterate()
 * 2、中间操作 ：过滤与切片（filter、limit）、映射(map、flatMap)、排序、
 * 3、终止操作 ：查找与匹配(findAny、findFirst、max、min、count、AllMatch、AnyMatch、noneMatch)、归约
 * 归约与收集（reduce）
 */
public class TestStreamAPI {
    private Person[] people = new Person[]{
            new Person("Jesse", 12),
            new Person("Jessie", 16),
            new Person("Jessica", 20),
            new Person("Monica", 24),
    };
    private List<Person> personList = Arrays.asList(people);

    public void testGenerate() {
        //创建方式1：通过Collection系列集合的stream和parallelStream方法
        Stream<Person> stream = personList.stream();
        //创建方式2：通过Arrays的静态方法stream获取数组流
        Stream<Person> personStream = Arrays.stream(people);
        //创建方式3：通过Stream.of();
        Stream<String> stream1 = Stream.of("AA", "BB", "CC", "DD");
        //创建方式4：创建无限流;
        Stream<Integer> stream2 = Stream.iterate(0, x -> x + 2);//（1）迭代
        Stream stream3 = Stream.generate(() -> Math.random());//（2）生成
    }

    private Employee[] emps = new Employee[]{
            new Employee("Jesse", 12, 5000.00, Status.BUSY),
            new Employee("Jessie", 16, 5500.00, Status.BUSY),
            new Employee("Jessica", 20, 4500.00, Status.AVAILABLE),
            new Employee("Monica", 24, 6500.00, Status.AVAILABLE),
    };
    private List<Employee> employeeList = Arrays.asList(emps);

    @Test
    public void testParallel() {
        //一至一百亿的累加和
        Instant start = Instant.now();
        LongStream.rangeClosed(0, 10000000000L)
                .parallel()
                .reduce(0, Long::sum);
        Instant end = Instant.now();
        System.out.println("并行流耗费时间：" + Duration.between(start, end).toMillis()+"毫秒");

        Instant start1 = Instant.now();
        LongStream.rangeClosed(0, 10000000000L)
                .reduce(0, Long::sum);
        Instant end1 = Instant.now();
        System.out.println("顺序流耗费时间：" + Duration.between(start1, end1).toMillis()+"毫秒");
    }

    @Test
    public void testCollect() {
        List<String> names = employeeList.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("names = " + names);

        HashSet<String> strings = employeeList.stream().map(Person::getName).collect(Collectors.toCollection(HashSet::new));
    }

    @Test
    public void testReduce() {
        Stream<Integer> ages = personList.stream().map(Person::getAge);
        Integer totalAge = ages.reduce(0, (x, y) -> x + y);
        System.out.println("totalAge = " + totalAge);
    }

    @Test
    public void TestFind() {
        Optional<Employee> availableEmp = Arrays.stream(emps)
                .filter(employee -> Status.AVAILABLE.equals(employee.getStatus()))
                .findAny();
        System.out.println("availableEmp = " + availableEmp);
        Optional<Employee> maxSalaryEmp = employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary));
    }

    @Test
    public void testMatch() {
        boolean allBusy = Arrays.stream(emps).allMatch(employee -> employee.getStatus() == Status.BUSY);
        boolean anyBusy = Arrays.stream(emps).anyMatch(employee -> employee.getStatus() == Status.BUSY);
        boolean noneVacation = Arrays.stream(emps).noneMatch(employee -> employee.getStatus() == Status.VACATION);
        System.out.println("allBusy = " + allBusy);
        System.out.println("anyBusy = " + anyBusy);
        System.out.println("noneVacation = " + noneVacation);
    }

    /**
     * 排序
     * sorted()
     * sorted(Comparator c)
     */
    @Test
    public void testSort() {
        Stream<Integer> ages = personList.stream().map(Person::getAge);
        Stream<Integer> ages2 = personList.stream().map(Person::getAge);
        System.out.println("---------自然排列的年龄---------");
        ages.sorted()
                .forEach(System.out::println);
        System.out.println("---------降序排列的年龄---------");
        ages2.sorted(Comparator.comparingInt(x -> -x))
                .forEach(System.out::println);
    }

    /**
     * map : 一个函数操作，应用到流中的每个元素上，并将其映射成一个新的元素。
     * flatMap : 一个函数操作，应用到流中的每个值（包含流中流的值）上，并将其映射成一个新的值，最后将所有的流连接成一个流。
     */
    @Test
    public void testMap() {
        //获取人员列表的年龄
        Stream<Integer> ages = personList.stream().map(Person::getAge);//.toArray();
        //获取人员列表的名字
        Stream<String> names = personList.stream().map(Person::getName);
        ages.forEach(System.out::println);
        names.forEach(System.out::println);
        //将所有字符转化为大写
        Arrays.stream(new String[]{"aaa", "bbb", "ccc"}).map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void testFlatMap() {
        Stream<String> names = personList.stream().map(Person::getName);
        Stream<String> names2 = personList.stream().map(Person::getName);
        names.map(this::toUpperCharsStream)
                .forEach(System.out::println);//输出流
        names2.flatMap(this::toUpperCharsStream)
                .forEach(System.out::println);//输出字母
    }

    private Stream<Character> toUpperCharsStream(String s) {
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(c >= 97 && c <= 122 ? (char) (c - 32) : c);
        }
        return list.stream();
    }

    @Test
    public void testFilter() {
        //过滤18岁以下的未成年人
        Stream<Person> personStream = Arrays.stream(people).filter(person -> person.getAge() >= 18);
        personStream.forEach(System.out::println);
    }
}
