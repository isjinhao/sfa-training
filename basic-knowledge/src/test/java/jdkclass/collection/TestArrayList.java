package jdkclass.collection;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/16
 */
public class TestArrayList {

    @Test
    public void test1() {
        /**
         * 按照一般人的理解，我已经初始化了容量为10，在索引为0位置设置数据已经没有错实际上是有错的。因为set()方法内部使用了rangeCheck()，这方法判断是否越界使用的是size，不是initialCapacity
         * 但是 add() 方法就没有问题，因为此方法会先进行扩容
         *
         */
        ArrayList<Object> objects = new ArrayList<>(8);
        // error
        objects.set(0, 123);
        objects.add(0, 123);
    }

    @Test
    public void test2() {
        /**
         * 按照一般人的理解，我已经初始化了容量为10，在索引为0位置设置数据不会造成错误，但实际上是有错的。
         * 因为set()方法内部使用了rangeCheck()，这方法判断是否越界使用的是size，不是initialCapacity
         * 但是 add() 方法就没有问题，因为此方法会先进行扩容
         *
         */
        ArrayList<Object> objects = new ArrayList<>();
        // error
//        objects.set(0, 123);
        objects.add(0, 123);
    }


    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }

}
