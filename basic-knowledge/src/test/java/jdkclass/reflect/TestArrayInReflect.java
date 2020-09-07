package jdkclass.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/5
 */
public class TestArrayInReflect {

    /**
     * 反射的方式获得数组指定位置的元素，获得特定的元素
     */
    @Test
    public void test1() {
        String[] strArr = {"123", "234", "345", "456"};
        /**
         * 还有getBoolean、getShort等方法
         */
        System.out.println(Array.get(strArr, 2));
    }

    @Test
    public void test2() {
        String[] strArr = {"123", "234", "345", "456"};
        System.out.println(Array.getLength(strArr));
    }

    @Test
    public void test3() {
        String[] strArr = {"123", "234", "345", "456"};
        Array.set(strArr, 2, "abc");
        System.out.println(Array.get(strArr, 2));
    }

    /**
     * 创建一维数组
     */
    @Test
    public void test4() throws Exception {
        Class<?> classType = Class.forName("java.lang.String");
        String[] array = (String[]) Array.newInstance(classType, 5);
        Array.set(array, 3, "abc");
        System.out.println(Arrays.deepToString(array));
    }

    /**
     * 创建多维数组
     */
    @Test
    public void test5() throws Exception {
        Class<?> classType = Class.forName("java.lang.Integer");
        Integer[][][] array3 = (Integer[][][]) Array.newInstance(classType, 2, 3, 4);

        Object array21 = Array.newInstance(classType, 3, 4);
        Object array22 = Array.newInstance(classType, 3, 4);

        Integer[] array311 = (Integer[]) createArrayWithData(classType, 4, 1, 2, 3, 4);
        Integer[] array312 = (Integer[]) createArrayWithData(classType, 4, 5, 6, 7, 8);
        Integer[] array313 = (Integer[]) createArrayWithData(classType, 4, 9, 10, 11, 12);

        Integer[] array321 = (Integer[]) createArrayWithData(classType, 4, 13, 14, 15, 16);
        Integer[] array322 = (Integer[]) createArrayWithData(classType, 4, 17, 18, 19, 20);
        Integer[] array323 = (Integer[]) createArrayWithData(classType, 4, 21, 22, 23, 24);

        Array.set(array21, 0, array311);
        Array.set(array21, 1, array312);
        Array.set(array21, 2, array313);

        Array.set(array22, 0, array321);
        Array.set(array22, 1, array322);
        Array.set(array22, 2, array323);

        Array.set(array3, 0, array21);
        Array.set(array3, 1, array22);

        System.out.println(Arrays.deepToString(array3));

    }

    public Object createArrayWithData(Class<?> classType, int dimensions, Object... objs) {
        Object array = Array.newInstance(classType, dimensions);
        for (int i = 0; i < dimensions; i++) {
            Array.set(array, i, objs[i]);
        }
        return array;
    }

}
