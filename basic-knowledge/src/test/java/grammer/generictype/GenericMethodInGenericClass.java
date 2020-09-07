package grammer.generictype;

public class GenericMethodInGenericClass {
    class Fruit {
        public String toString() { return "fruit"; }
    }
    class Apple extends Fruit {
        public String toString() { return "apple"; }
    }
    class Person {
        public String toString() { return "Person"; }
    }

    class GenerateTest<T> {

        /**
         * 方法中的T和类上声明的T一致
         * @param t
         */
        public void show_1(T t){
            System.out.println(t.toString());
        }

        /**
         * 泛型类中声明了一个泛型方法，使用泛型E，泛型E可以为任意类型。可以类型与T相同，也可以不同。
         * 由于泛型方法在声明的时候会声明泛型<E>，因此即使在泛型类中并未声明泛型，编译器也能够正确识
         * 别泛型方法中识别的泛型。
         * @param t
         * @param <E>
         */
        public <E> void show_2(E t) {
            System.out.println(t.toString());
        }

        /**
         * 泛型类中声明了一个泛型方法，使用泛型T，这个T是一种全新的类型，即泛型方法的T覆盖了泛型类的T
         * 编译器会报警告：The type parameter T is hiding the type T
         * @param t
         * @param <T>
         */
        public <T> void show_3(T t) {
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {
        Apple apple = new GenericMethodInGenericClass().new Apple();
        Person person = new GenericMethodInGenericClass().new Person();

        GenerateTest<Fruit> generateTest = new GenericMethodInGenericClass().new GenerateTest<>();

        /**
         * apple是Fruit的子类，所以这里可以，此时实际上是多态的性质
         */
        generateTest.show_1(apple);
        // 编译器会报错，因为泛型类型实参指定的是Fruit，而传入的实参类是Person
        // generateTest.show_1(person);

        // 使用这两个方法都可以成功
        generateTest.show_2(apple);
        generateTest.show_2(person);

        // 使用这两个方法也都可以成功
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }
}