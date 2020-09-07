package jdkclass.collection;

import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/7
 */
public class TestList {

    /**
     * List接口本身没有提供 get(Object o) 方法，但是提供了 contains(Object o) 方法。
     * contains(Object o) 的实现是在 AbstractCollection 里面进行的。
     *
     * List接口提供了 get(int index) 方法。这个方法的实现被放在了具体的集合本身，比如 ArrayList、LinkedList
     */
    @Test
    public void test1() {

    }



}
