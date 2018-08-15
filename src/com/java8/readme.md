# Java8新特性
## 一、速度更快
1、HashMap，
2、ConcurrentHashMap的锁分段机制替换为CAS
3、内存优化：去掉JVM永久区，增加元空间
## 二、代码减少 -- Lambda表达式
### 1、新操作符 -> 和它的语法
 -> 表达式的两侧：
- 左侧：lambda表达式的参数列表

接口方法的参数列表

- 右侧：lambda表达式中需要执行的功能

接口方法的方法实现

- 语法格式一：无参数，无返回值 

如：
```java
Runnable r = () -> System.out.println("Hello lambda!");
r.run();
```

- 语法格式二：有参数，无返回值。只有一个参数小括号可以省略不写

如：(args) -> System.out.println(args)
```java
Consumer<String> con = (x) -> System.out.println(x);//省略括号con = x -> System.out.println(x);
con.accept("Hello");//print hello 
```

- 语法格式三：有参数、有返回值(多条语句)
```java
Comparator<Integer> c = (x,y) -> {
    System.out.println("函数式接口");
    return x-y;
};
int returnVal = c.compare(1,2);
//如果只有一条语句{}和return都可以省略
Comparator<Integer> c = (x,y) -> x-y;
```

- 语法格式四：参数列表的数据类型可以省略
JVM编译器可以根据上下文推断出参数的数据类型，即“类型推断”

总结：
上联：左右遇一括号省
下联：左侧推断类型省
横批：能省则省

### 2、lambda表达式需要函数式接口的支持

函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用@FunctionalInterface注解检查是否是函数式接口

### 3、Java8 内置四大核心函数式接口

- Consumer<T> : 消费型接口
     void accept(T t)

- Supplier<T> : 供给型接口
     T get()
     
- Function<T,R> : 函数型接口
     R apply(T t)

- Predicate<T> : 断言型接口
     Boolean test(T t)

**举例**
```java
class Tester{
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
```
### 4、方法和构造器引用

若lambda方法体中内容已经实现了，我们可以使用方法引用。
主要有三种语法：

- 对象::实例方法名
- 类::静态方法名
- 类::实例方法名

举例：
```java
public class TestMethodReference {
    @Test
    public void test1() {
        //Consumer consumer = x -> System.out.println(x);
        Consumer consumer = System.out::println;
        consumer.accept("Hello lambda!");
    }
}
```
**要求**：函数式接口与被引用方法必须具有相同的参数列表和返回类型

## 三、强大的Stream API
### 1、认识Stream API

### 2、创建Stream
**创建Stream** : `CollectionImpls.stream()/parallelStream() 、Arrays.Stream()、Stream.of()、无限流stream.generate()/iterate()`
```java
public class TestStreamAPI {
    public void testGenerate() {
        //创建方式1：通过Collection系列集合的stream和parallelStream方法
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //创建方式2：通过Arrays的静态方法stream获取数组流
        Stream<User> emps = Arrays.stream(new User[]{new User("001", "Jesse"), new User("002", "Tom")});
        //创建方式3：通过Stream.of();
        Stream<String> stream1 = Stream.of("AA", "BB", "CC", "DD");
        //创建方式4：Stream.iterate()/generate()创建无限流;
        Stream<Integer> stream2 = Stream.iterate(0, x -> x + 2);//（1）迭代
        Stream stream3 = Stream.generate(() -> Math.random());//（2）生成
    }
}
```
### 3、中间操作
过滤（filter）、截断（limit）、跳过（skip）
```java
public class TestStreamAPI{
    @Test
    public void testFilter() {
        Person[] people = new Person[]{
                new Person("Jesse", 12),
                new Person("Jessie", 16),
                new Person("Jessica", 20),
                new Person("Monica", 24),
                new Person("Mary",28),
                new Person("Mary",28),
                new Person("Maria",32)
        };
        
        Stream<Person> personStream = Arrays.stream(people).skip(2)//跳过前四个
            .distinct()//过滤相同
            .filter(person -> person.getAge() >= 18)//过滤18岁以下的未成年人
            .limit(3);//限制只找三个满足条件的元素
        personStream.forEach(System.out::println);
    }
}
```
映射：

map : 一个函数操作，应用到流中的每个元素上，并将其映射成一个新的元素。

flatMap : 一个函数操作，应用到流中的每个值（包含流中流的值）上，并将其映射成一个新的值，最后将所有的流连接成一个流。

```java
@Test
public void testFlatMap() {
    Stream<String> names = personList.stream().map(Person::getName);
    Stream<String> names2 = personList.stream().map(Person::getName);
    names.map(this::toUpperCharsStream)
            .forEach(System.out::println);//输出流
    names2.flatMap(this::toUpperCharsStream)
            .forEach(System.out::println);//输出字母
}
public Stream<Character> toUpperCharsStream(String s) {
    List<Character> list = new ArrayList<>();
    for (Character c : s.toCharArray()) {
        list.add(c >= 97 && c <= 122 ? (char) (c - 32) : c);
    }
    return list.stream();
}
```
排序：sorted、 sorted(Comparator<? super T> comparator)
```java
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
```
### 4、终止操作
查找与匹配：findAny findFirst max min count allMatch anyMatch noneMatch
```java
Optional<Employee> availableEmp = Arrays.stream(emps)
        .filter(employee -> Status.AVAILABLE.equals(employee.getStatus()))
        .findAny();
System.out.println("availableEmp = " + availableEmp);
boolean allBusy = Arrays.stream(emps).allMatch(employee -> employee.getStatus() == Status.BUSY);
System.out.println("allBusy = " + allBusy);
```
归约与收集：reduce,collect
```java
//归约
Stream<Integer> ages = personList.stream().map(Person::getAge);
Integer totalAge = ages.reduce(0, (x, y) -> x + y);
System.out.println("totalAge = " + totalAge);
//收集-将流转化为其他形式
List<String> names = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
System.out.println("names = " + names);
//收集到特殊集合中
HashSet<String> strings = employeeList.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
//总和、平均值、最大最小值、分组、分片...
Double totalSalary = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary);
Map<Status,List<Employee>> statusGroup = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus);
```
### 5、顺序流与并行流
Java8并行流使用类似ForkJoin框架的方式计算，极大地提高了超大任务的运行效率。
可以通过sequenceStream.parallel产生并行流，
```java
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
```
## 四、更好的并行机制
## 五、最大化减少空指针异常
### Optional类
Java8提供了一个Optional<T>容器类，代表一个值存在或不存在，原来用null表示一个值不存在，现在Optional可以更好的表达这个概念。并且可以避免空指针异常。

常用方法：

- Optional.of(T t):创建一个Optional的实例
- Optional.empty():创建一个空的Optional实例
- Optional.ofNullable(T t):若t不为null，创建Optional实例，否则创建空实例
- isPresent():判断是否包含值
- orElse(T t):如果调用对象包含值，返回该值，否则返回T
- orElseGet(Supplier s):如果调用对象包含值，返回该值，否则返回s产生的值
- map(Function f):如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
- flatMap(Function mapper):与map类似，要求返回值必须是Optional

