package grammer.innerclass;

import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class LocalInnerClass {

    @Test
    public void test1() {

        /**
         * 这是一个很神奇的问题，我以为这个Man是不可被访问的，但是实际上却可以被访问
         */
        Person woman = new Person().new Man().getBoy();
        System.out.println(woman.getClass());
        woman.show();

    }

}

class Person {
    public void show() {
        System.out.println("I am Person");
    }

    /**
     * 除了 private 其他的修饰都可以访问，神奇
     */
    protected class Man extends Person {
        @Override
        public void show() {
            System.out.println("I am Man");
        }
        public Person getBoy() {
            class Boy extends Man {
                @Override
                public void show() {
                    System.out.println("I am Boy");
                }
            }
            return new Boy();
        }
    }
}