package grammer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/14
 */
public class TestStreamCollect {

    /**
     * `reduce()`擅长的是生成一个值，如果想要从Stream生成一个集合或者Map等复杂的对象该怎么办呢？
     * 就需要用到`collect()`了，也就是说它可以把Stream中的要有元素收集到一个结果容器中。其有两种重载的方法：
     * 1、
     *  <R> R collect(Supplier<R> supplier,
     *                   BiConsumer<R, ? super T> accumulator,
     *                   BiConsumer<R, R> combiner);
     * Performs a mutable reduction operation on the elements of this stream. A mutable reduction is one in which the reduced value is a mutable result container,
     * such as an ArrayList, and elements are incorporated（合并） by updating the state of the result rather than by replacing the result. This produces a result equivalent to:
     *  R result = supplier.get();
     *  for (T element : this stream)
     *      accumulator.accept(result, element);
     *  return result;
     * Like reduce(Object, BinaryOperator), collect operations can be parallelized without requiring additional synchronization. This is a terminal operation.
     *
     * 2、
     *  <R, A> R collect(Collector<? super T, A, R> collector);
     * Performs a mutable reduction operation on the elements of this stream using a Collector. A Collector encapsulates the functions used as arguments to
     * collect(Supplier, BiConsumer, BiConsumer), allowing for reuse of collection strategies and composition of collect operations such as multiple-level grouping or partitioning.
     */

    @Test
    public void test1() {
        /**
         * 在不使用API之前我们先考虑一下将一个`Stream`转换成一个容器（或者`Map`）需要做哪些工作？至少需要两样东西吧：
         *
         * 1. 目标容器是什么？是`ArrayList`还是`HashSet`，或者是个`TreeMap`。
         * 2. 新元素如何添加到容器中？是`List.add()`还是`Map.put()`。
         * 3. 如果并行的进行规约，还需要告诉`collect()`多个部分结果如何合并成一个。
         *
         * 结合以上分析，`collect()`方法定义为`R collect(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)`，三个参数依次对应上述三条分析。
         * 不过每次调用`collect()`都要传入这三个参数太麻烦，收集器`Collector`就是对这三个参数的简单封装，所以`collect()`的另一定义为`R collect(Collector collector)`。
         * `Collectors`工具类可通过静态方法生成各种常用的`Collector`。举例来说，如果要将`Stream`规约成`List`可以通过如下两种方式实现：
         */

        //　将Stream规约成List
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);  // 方式１
//        List<String> list = stream.collect(Collectors.toList());  // 方式2
        System.out.println(list.getClass());

        /**
         * 通常情况下我们不需要手动指定`collect()`的三个参数，而是调用`collect(Collector collector)`方法，并且参数
         * 中的`Collector`对象大都是直接通过`Collectors`工具类获得。实际上传入的收集器的行为决定了`collect()`的行为。
         */
    }


    @Test
    public void test2() {

        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList()); // 1
        Set<String> set = stream.collect(Collectors.toSet()); // 2
        System.out.println(list.getClass());
        System.out.println(set.getClass());

        // 使用toCollection()指定规约容器的类型
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new)); // 3
        HashSet<String> hashSet = stream.collect(Collectors.toCollection(HashSet::new)); // 4
        System.out.println(arrayList.getClass());
        System.out.println(hashSet.getClass());

    }


    @Test
    public void test3() {

        List<String> list1 = Arrays.asList("Hi", "Hello");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu");
        List<String> result =
            list1.stream()
                .flatMap(item1 -> list2.stream().map(item2 -> item1 + " " + item2))
                .collect(Collectors.toList());
        System.out.println(result);


        Stream<Stream<String>> streamStream = list1.stream()
            .map(item -> list2.stream().map(item2 -> item + " " + item2));
        List<Stream<String>> collect = list1.stream()
            .map(item -> list2.stream().map(item2 -> item + " " + item2))
            .collect(Collectors.toList());


        Stream<String> stringStream = list1.stream()
            .flatMap(item -> list2.stream().map(item2 -> item + " " + item2));
        List<String> collect1 = list1.stream()
            .flatMap(item -> list2.stream().map(item2 -> item + " " + item2))
            .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println(collect1);
        List<String> list3 = Arrays.asList("a", "b", "c");

        List<String> result3 =
            list1.stream()
                .flatMap(item1 -> list2.stream().flatMap(item2 -> list3.stream().map(item3 -> item1 + " " + item2 + " " + item3)))
                .collect(Collectors.toList());

        System.out.println(result3);

    }


    @Test
    public void test4() {

        Student student1 = new Student("123", 90, 20);
        Student student2 = new Student("234", 80, 20);
        Student student3 = new Student("345", 100, 20);
        Student student4 = new Student("456", 70, 20);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // 使用toMap()统计学生成绩
        Map<String, Integer> studentToScore =
            students.stream().collect(Collectors.toMap(student -> student.getName(),     // 如何生成key
                student -> student.getScore()));   // 如何生成value
        System.out.println(studentToScore);
    }


    @Test
    public void test5() {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        Map<Boolean, List<Student>> map = students.stream().
            collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map);

        // 对于结果为真部分的数据再次进行分区
        Map<Boolean, Map<Boolean, List<Student>>> map3 =
            students.stream().collect(
                Collectors.partitioningBy(student -> student.getScore() > 80, Collectors.partitioningBy(student -> student.getScore() <= 90))
            );
        System.out.println(map3);
    }


    @Test
    public void test6() {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);


        Map<Integer, List<Student>> map1 = students.stream().
            collect(Collectors.groupingBy(Student::getScore));
        System.out.println(map1);


        Map<Integer, Map<String, List<Student>>> map2 = students.stream().
            collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(map2);
    }


    @Test
    public void test7() {
        Stream<String> stream = Stream.of("I", "love", "you");
        // String joined = stream.collect(Collectors.joining());  // "Iloveyou"
        // String joined = stream.collect(Collectors.joining(","));  // "I,love,you"
        String joined = stream.collect(Collectors.joining(",", "{", "}"));  // "{I,love,you}"
        System.out.println(joined);
    }


    @Test
    public void test8() {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // 获得每个姓名下的最低分，返回的是Optional，但实际上此时的最低分一定不为空
        Map<String, Optional<Student>> collect = students.stream()
            .collect(Collectors.groupingBy(Student::getName, Collectors.minBy(Comparator.comparingInt(Student::getScore))));
        System.out.println(collect);

        // 所以可以只用collectingAndThen，传入一个 Function
        Map<String, Student> map5 = students.stream()
            .collect(Collectors.groupingBy(Student::getName, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));
        System.out.println(map5);
    }


    class Student {

        private String name;
        private int score;
        private int age;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public Student(String name, int score, int age) {
            this.name = name;
            this.score = score;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getScore() {
            return score;
        }
        public void setScore(int score) {
            this.score = score;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
        }
    }

}

