package grammer.generictype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/7/31
 */
public class SelfBounded<T extends SelfBounded<T>> {

    /**
     * 让我们先来看一个问题，如果我有一个类定义为 SelfBounded<T>。在继承的时候可以这样使用 class A extends SelfBounds<B>。
     */
    class SelfB<T> {
        protected T t;
    }
    class A extends SelfB<String> {

    }

    /**
     * 但是还有一种方法是 class B extends SelfBounded<B>，此时就构成自限定（self-bounded）了。最常见的类型就是 Comparable<T> 。
     * 使用的时候 class Person implements Comparable<Person>。此时 Comparable 类里使用了泛型参数的方法在和B类进行交互的对象也是B类型了
     * 这样就构成了B类对象和B类对象进行交互。
     */
    class B implements Comparable<B>{

        @Override
        public int compareTo(B o) {
            return 0;
        }

    }

    /**
     * 经常能看到一种泛型的写法是：<T extends Comparable<T>>。它的意思是传入的类型必须是自限定类型。
     */
    public static <T extends Comparable<T>> void mySort1(List<T> list)	{
        Collections.sort(list);
    }

    @Test
    public void test1(){
        /**
         * 创建一个 Animal List
         */
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(25));
        animals.add(new Dog(35));

        /**
         * 创建一个 Dog List
         */
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(5));
        dogs.add(new Dog(18));

        /**
         * 测试 mySort1() 方法
         */
        mySort1(animals);
        System.out.println(animals);
//        mySort1(dogs);		// error
    }


    /**
     * 可以认为是自限定类型的托拓展，这样声明的类不仅Animal可以进行排序，Dog也可以进行排序。
     * - 在添加animals时，T是Animal，Comparable的泛型是Animal，`Animal super Animal`成立。
     * - 在添加dogs时，T是Dog，Comparable的泛型是Animal，`Animal super Dog`成立。
     *
     */
    public static <T extends Comparable<? super T>> void mySort2(List<T> list) {
        Collections.sort(list);
    }

    @Test
    public void test2() {
        /**
         * 创建一个 Animal List
         */
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog(35));
        animals.add(new Animal(25));

        /**
         * 创建一个 Dog List
         */
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(18));
        dogs.add(new Dog(5));

        /**
         * 测试 mySort1() 方法
         */
        mySort2(animals);
        System.out.println(animals);
        mySort2(dogs);
        System.out.println(dogs);
    }

    private T t;

    void test() {
        t.sayHello();
    }

    void sayHello() {
        System.out.println("hello");
    }


    class Animal implements Comparable<Animal> {
        protected int age;
        public Animal(int age) {
            this.age = age;
        }
        // 使用年龄与另一实例比较大小
        @Override
        public int compareTo(Animal other) {
            return this.age - other.age;
        }

        @Override
        public String toString() {
            return "Animal{" +
                "age=" + age +
                '}';
        }
    }

    class Dog extends Animal {
        public Dog(int age) {
            super(age);
        }

        @Override
        public String toString() {
            return "Dog{" +
                "age=" + age +
                '}';
        }
    }

}

class Son extends SelfBounded<Son> {

}