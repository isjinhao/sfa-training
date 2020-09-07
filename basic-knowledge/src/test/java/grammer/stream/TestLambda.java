package grammer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/12
 */
public class TestLambda {

    /**
     * @return void
     * @description: 传递行为而不是传递对象
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test1() throws Exception {
        /**
         * 在Java中，我们只能传递和返回值，而无法将函数作为参数传递给一个方法，也无法声明返回一个函数的方法。所以在代码中，
         * 我们不能传递一个行为，只能将行为包装成为一个对象来进行传递。比如下面的Swing：
         */
//        JFrame jFrame = new JFrame("My JFrame");
//        JButton jButton = new JButton("JButton");
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Button Pressed! ");
//            }
//        });
//        jFrame.add(jButton);
//        jFrame.pack();
//        jFrame.setVisible(true);
//        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        TimeUnit.SECONDS.sleep(10);

        /**
         * 对于上面的代码，我们实际上不需要`new ActionListener()`、`actionPerformed`等等，我们只需要sout这个行为。传统
         * 的匿名内部类却必须需要构建一个对象传入。而Lambda表达式便可以直接的传递一个行为进去。
         */
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("JButton");

        // 单行直接写，多行使用花括号{}括起来
        // event 全写是 ActionEvent event，即全写：(ActionEvent event) -> sout
        // 这里只写event是因为Java的编译系统能推断出来这个地方的event就是Action Event
        jButton.addActionListener(event -> System.out.println("Button Pressed! "));
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * @return void
     * @description: 函数式接口
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test2() {
        /**
         * 函数式接口：一个接口中只有一个抽象方法就被叫做函数式接口。
         * - 如果一个接口只有一个抽象方法，他就是一个函数式接口。
         * - 如果我们在接口上声明了`@FunctionalInterface`，编译期会按函数式接口的定义来要求他，如果不满足函数式接口的定义，编译期会报错。
         * - 如果某个接口只有一个函数式接口，即使没有加`@FunctionalInterface`，编译器也将其看成函数式接口。
         * - 如果某个接口覆盖了`Object`中的方法，那么此接口的抽象方法不会加一，如以下代码：
         */
//        @FunctionalInterface
//        public interface MyTest2 {
//            void test();
//
//            // 不会报错，
//            @Override
//            boolean equals(Object obj);
//        }

        /**
         * 在函数作为一等公民的语言中，函数被看做类型，而在Java中，Lambda表达式是对象，他们必须依附一类特别的对象类型 - 函数式接口。
         */
    }


    /**
     * @return void
     * @description: Lambda的小例子
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test3() {
        List<String> list = Arrays.asList("abc", "test", "hello");

        // 匿名内部类完成遍历
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String string) {
                System.out.println(string);
            }
        });

        // lambda expressions
        list.forEach(item -> System.out.println(item));

        // method references
        list.forEach(System.out::println);
    }


    /**
     * @return void
     * @description: Lambda基本语法
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test4() {

        /**
         * Lambda 表达式的语法格式如下：
         *  (parameters) -> expression
         *  或
         *  (parameters) ->{ statements; }
         *
         * 以下是lambda表达式的重要特征：
         *  - 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
         *  - 可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
         *  - 可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
         *  - 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，如果使用了大括号需要指定表达式返回了一个数值。
         */
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + this.operate(10, 5, addition));
        System.out.println("10 - 5 = " + this.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + this.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + this.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }


    /**
     * @return void
     * @description: 变量作用域
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test5() {

        /**
         * Lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 Lambda 内部修改定义在域外的局部变量，否则会编译错误。
         */

        GreetingService greetService1 =
            message -> System.out.println(salutation + message);
        greetService1.sayMessage("Runoob");

        int num = 1;
        Converter<Integer, String> s = (param) -> String.valueOf(param + num);
        System.out.println(s.convert(2));

//        此行导致上面的Lambda表达式报错，因为Lambda表达式引用的外面的变量必须是 effective final 的
//        num = 5;

//     在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量
        String first = "";
//        Comparator<String> comparator = (first, second) ->
//		        Integer.compare(first.length(), second.length());  // 编译会出错
    }

    final static String salutation = "Hello! ";


    /**
     * @return void
     * @description: compose & andThen
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test6() {
        /**
         * Function<T, R>：Represents a function that accepts one argument and produces a result. This is a functional interface whose functional method is `R apply(T t)`.
         */
        System.out.println(this.compute(1, integer -> integer + 1));
        System.out.println(this.convert(1, integer -> String.valueOf(integer)));

        System.out.println(this.compute1
            (2, value -> value * 3, value -> value * value));    // 12
        System.out.println(this.compute2
            (2, value -> value * 3, value -> value * value));    // 36
    }

    int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    /**
     * 先应用f2，再应用f1
     */
    int compute1(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        /**
         * default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
         *     Objects.requireNonNull(before);
         *     return (V v) -> apply(before.apply(v));
         * }
         *
         * Returns a composed function that first applies the before function to its input, and then applies this function
         * to the result. If evaluation of either function throws an exception, it is relayed to the caller of the composed function.
         */
        return f1.compose(f2).apply(a);
    }

    /**
     * 先应用f1，再应用f2
     */
    int compute2(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        /**
         * default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
         *     Objects.requireNonNull(after);
         *     return (T t) -> after.apply(apply(t));
         * }
         *
         * Returns a composed function that first applies this function to its input, and then applies the after function to the result.
         * If evaluation of either function throws an exception, it is relayed to the caller of the composed function.
         */
        return f1.andThen(f2).apply(a);
    }


    /**
     * @return void
     * @description: BiFunction<T, U, R>：Represents a function that accepts two arguments and produces a result. `R apply(T t, U u);`
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test7() {
        System.out.println(compute1(2, 1, (a, b) -> a + b)); // 3
        System.out.println(compute1(2, 1, (a, b) -> a - b)); // 1
        System.out.println(compute1(2, 1, (a, b) -> a * b)); // 2
        System.out.println(compute1(2, 1, (a, b) -> a / b)); // 2

        System.out.println(compute2(2, 3, (a, b) -> a + b, a -> a * a)); // 25
    }

    static int compute1(int a, int b, BiFunction<Integer, Integer, Integer> bf) {
        return bf.apply(a, b);
    }

    static int compute2(int a, int b, BiFunction<Integer, Integer, Integer> bf, Function<Integer, Integer> f) {
        return f.apply(bf.apply(a, b));
    }


    /**
     * @return void
     * @description: BiFunction<T, U, R> Demo
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test8() {
        Person p1 = new Person("zhangsan", 12);
        Person p2 = new Person("lisi", 13);
        Person p3 = new Person("wangwu", 14);

        List<Person> list = new ArrayList<>(Arrays.asList(p1, p2, p3));
        // 过滤年龄等于13的
        System.out.println(getPersonList(13, list,
            (age, persons) -> persons.stream().filter(
                person -> (age == person.getAge())).collect(Collectors.toList())));
        // 过滤年龄大于13的
        System.out.println(getPersonList(13, list,
            (age, persons) -> persons.stream().filter(
                person -> (age < person.getAge())).collect(Collectors.toList())));
        // 过滤年龄小于13的
        System.out.println(getPersonList(13, list,
            (age, persons) -> persons.stream().filter(
                person -> (age > person.getAge())).collect(Collectors.toList())));
    }

    static List<Person> getPersonList(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> bf) {
        return bf.apply(age, persons);
    }


    /**
     * @return void
     * @description: BinaryOperator<T>：Represents an operation upon two operands of the same type, producing a result of the same type as the operands. This is
     * a specialization of BiFunction for the case where the operands and the result are all of the same type.
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test9() {
        System.out.println(getShort("hello123", "world", (a, b) -> a.length() - b.length()));
        System.out.println(getShort("hello123", "world", (a, b) -> a.charAt(0) - b.charAt(0)));
        System.out.println("--------------------");
        System.out.println(getBig("hello123", "world", (a, b) -> a.length() - b.length()));
        System.out.println(getBig("hello123", "world", (a, b) -> a.charAt(0) - b.charAt(0)));
    }

    static String getShort(String a, String b, Comparator<String> c) {
        // c的结果小于0返回a，否则返回b
        return BinaryOperator.minBy(c).apply(a, b);
    }

    static String getBig(String a, String b, Comparator<String> c) {
        // c的结果大于0返回a，否则返回b
        return BinaryOperator.maxBy(c).apply(a, b);
    }


    /**
     * @return void
     * @description: Predicate<T>：Represents a predicate (boolean-valued function) of one argument.
     * This is a functional interface whose functional method is test(Object).
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test10() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        conditionFilter(list, item -> item % 2 == 0);
        System.out.println("-----------");
        conditionFilter(list, item -> item % 2 != 0);
        System.out.println("-----------");
        conditionFilter(list, item -> item > 5);
        System.out.println("-----------");
        conditionFilter(list, item -> true);
    }

    static void conditionFilter(List<Integer> list, Predicate<Integer> pd) {
        list.forEach(integer -> {
            if (pd.test(integer)) {
                System.out.print(integer + " ");
            }
        });
        System.out.println();
    }


    @Test
    public void test11() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        conditionFilterAnd(list, item -> item % 2 == 0, item -> item > 5);
        System.out.println("-------------");
        conditionFilterOr(list, item -> item % 2 == 0, item -> item > 5);
        System.out.println("-------------");
        conditionFilterNegate(list, item -> item % 2 == 0);
    }

    static void conditionFilterAnd(
        List<Integer> list, Predicate<Integer> pd1, Predicate<Integer> pd2) {
        list.forEach(integer -> {
            if (pd1.and(pd2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

    static void conditionFilterOr(
        List<Integer> list, Predicate<Integer> pd1, Predicate<Integer> pd2) {
        list.forEach(integer -> {
            if (pd1.or(pd2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

    static void conditionFilterNegate(
        List<Integer> list, Predicate<Integer> pd1) {
        list.forEach(integer -> {
            if (pd1.negate().test(integer)) {
                System.out.println(integer);
            }
        });
    }


    /**
     * @return void
     * @description: Consumer<T>：Represents an operation that accepts a single input argument and returns no result. Unlike most other functional interfaces,
     * Consumer is expected to operate via side-effects. `void accept(T t);`
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test12() {

        Consumer<Integer> square = x -> System.out.println("print square : " + x * x);
        square.accept(2);

        /**
         * andThen
         * Returns a composed Consumer that performs, in sequence, this operation followed by the after operation. If performing either operation throws an exception,
         * it is relayed to the caller of the composed operation. If performing this operation throws an exception, the after operation will not be performed.
         */
        Consumer<Integer> consumer1 = x -> System.out.println("first x : " + x);
        Consumer<Integer> consumer2 = x -> {
            System.out.println("second x : " + x);
            throw new NullPointerException("throw exception test");
        };
        Consumer<Integer> consumer3 = x -> System.out.println("third x : " + x);
        consumer1.andThen(consumer2).andThen(consumer3).accept(1);

    }


    /**
     * @return void
     * @description: BiConsumer<T, U>：Represents an operation that accepts two input arguments and returns no result. This is the two-arity specialization of Consumer.
     * Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects. `void accept(T t, U u);`
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test13() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }


    /**
     * @return void
     * @description: Supplier<T>：Represents a supplier of results. There is no requirement that a new or distinct result be returned each time the supplier is invoked. `T get();`
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test14() {

        Supplier<Person> personSupplier = () -> new Person("123", 1);
        System.out.println(personSupplier.get());

    }

    /**
     * @return void
     * @description: Lambda 不是语法糖
     * @params:
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test15() {
        /**
         * Lambda 不是内部类
         */
        Runnable r1 = () -> System.out.println(this);
        Runnable r2 = () -> System.out.println(toString());
        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }
        };

        r1.run();
        r2.run();
        r3.run();
    }

    @Override
    public String toString() {
        return "Lambda 不是语法糖";
    }


    /**
     * @description: Optional<T>：A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get()
     * will return the value. Additional methods that depend on the presence or absence of a contained value are provided,
     * such as orElse() (return a default value if value not present) and ifPresent() (execute a block of code if the value is present).
     * This is a value-based class; use of identity-sensitive operations (including reference equality (==), identity hash code, or synchronization)
     * on instances of Optional may have unpredictable results and should be avoided.
     * @params: null
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test16() {

        Employee e1 = new Employee("zhangsan");
        Employee e2 = new Employee("lisi");

        Company company = new Company("test");

        List<Employee> employees = Arrays.asList(e1, e2);
        company.setEmployees(employees);    // 注释掉此句，最终输出的是[]。不是null

        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(comp -> comp.getEmployees()).orElse(Collections.emptyList()));

    }


    /**
     * @description: 方法引用
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/12
     */
    @Test
    public void test17() {
        /**
         * 方法引用是 Lambda 的一个语法糖。我们可以将其看作是一个函数指针。方法引用有四种：
         *  - 类名::静态方法名
         *  - 对象::实例方法名
         *  - 类名::实例方法名
         *  - 构造方法引用
         */
        Student s1 = new Student("zhangsan", 10);
        Student s2 = new Student("lisi", 20);
        Student s3 = new Student("wangwu", 30);
        Student s4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(s1, s2, s4, s3);

        // sort方法需要一个Comparator，Comparator的抽象方法是：int compare(T o1, T o2);
        // 我们传入的参数是两个Student类型的对象，返回的是一个int型数据
//        students.sort((s1p, s2p) -> Student.compareByScore(s1p, s2p));

        // compareByScore这个方法接收两个Student类型的对象，
        // 返回一个int型数据，可以满足我们的需要，所以编译器能识别成功
        students.sort(Student::compareByScore1);

        // forEach方法需要一个Consumer，Consumer的抽象方法是：void accept(T t);
        // System.out.println(...) 满足一个参数，没有返回值的要求，所以可以被编译器识别
        students.forEach(System.out::println);
        System.out.println("----------------");

        students.sort(s1::compareByName2);
        students.forEach(System.out::println);
        System.out.println("----------------");

        // Comparator的抽象方法是：int compare(T o1, T o2);
        // 在这种写法中，第一个参数会去调用compareByScore3，将第二个参数传入
        // 如果函数式接口的抽象方法有三个以上的参数，第一个参数用于调用方法，后面的参数都会用于传入
        students.sort(Student::compareByScore3);
        students.forEach(System.out::println);
        System.out.println("----------------");

        // 调用String的无参构造方法，返回一个String对象
        System.out.println(getString(String::new));
        // 调用public String(String original) 构造方法
        System.out.println(getString("123", String::new));
    }
    static String getString(Supplier<String> s){
        return s.get() + "abc";
    }
    static String getString(String str, Function<String, String> f){
        return f.apply(str);
    }




}


interface MathOperation {
    int operation(int a, int b);
}

interface GreetingService {
    void sayMessage(String message);
}

interface Converter<T1, T2> {
    String convert(int i);
}

class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }
}

class Employee {
    private String name;
    public Employee(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Company {
    private String name;
    private List<Employee> employees;
    public Company(String name) {
        this.name = name;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

class Student {
    private String name;
    private int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String getName() {   return name;    }
    public void setName(String name) {  this.name = name;   }
    public int getScore() { return score;   }
    public void setScore(int score) {   this.score = score; }

    // 此方法违背了面向对象的设计原则，实际使用中不推荐
    public static int compareByScore1(Student s1, Student s2) {
        return s1.score - s2.score;
    }
    // 此方法违背了面向对象的设计原则，实际使用中不推荐
    public int compareByName2(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
    public int compareByScore3(Student s){
        return this.score - s.score;
    }
    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
    }
}