package jdkclass;

import java.util.ArrayList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestArrays {

    /**
     * @return void
     * @description: 排序
     * @params:
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test1() {
        int a[] = {1, 3, 2, 7, 6, 5, 4, 9};     // 支持 int long short double float char byte
        // sort(int[] a)方法按照数字顺序排列指定的数组。
        Arrays.sort(a);
        System.out.println("Arrays.sort(a):");
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();

        // sort(int[] a, int fromIndex, int toIndex)按升序排列数组的指定范围
        int b[] = {1, 3, 2, 7, 6, 5, 4, 9};
        Arrays.sort(b, 2, 6);   // [2, 6)
        System.out.println("Arrays.sort(b, 2, 6):");
        for (int i : b) {
            System.out.print(i);
        }
    }

    /**
     * @return void
     * @description: 二分查找
     * @params:
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test2() {

        char[] e = {'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B'};
        // 排序后再进行二分查找，否则找不到
        Arrays.sort(e);
        System.out.println("Arrays.sort(e)" + Arrays.toString(e));
        System.out.println("Arrays.binarySearch(e, 'c')：");
        int s = Arrays.binarySearch(e, 'c');    // 进行排序查找的序列必须是升序有序
        System.out.println("字符c在数组的位置：" + s);
    }


    /**
     * @return void
     * @description: 相等
     * @params:
     * @author: 01395265
     * @date: 2020/7/27
     */
    @Test
    public void test3() {
        char[] e = {'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B'};
        char[] f = {'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B'};
        /**
         * 元素数量相同，并且相同位置的元素相同（基本类型使用等号进行判断，Object类型采用equals方法进行判断）。
         * 如果两个数组引用都是null，则它们被认为是相等的。
         */
        System.out.println("Arrays.equals(e, f):" + Arrays.equals(e, f));
    }


    /**
     * @return void
     * @description: 使用特定元素填充数组或数组的某一部分
     * @params:
     * @author: 01395265
     * @date: 2020/7/28
     */
    @Test
    public void test4() {
        int[] g = {1, 2, 3, 3, 3, 3, 6, 6, 6};
        // 数组中所有元素重新分配值
        Arrays.fill(g, 3);
        System.out.println("Arrays.fill(g, 3)：");
        // 输出结果：333333333
        for (int i : g) {
            System.out.print(i);
        }
        // 换行
        System.out.println();

        int[] h = {1, 2, 3, 3, 3, 3, 6, 6, 6,};
        // 数组中指定范围元素重新分配值
        Arrays.fill(h, 0, 2, 9);    // [0, 2)
        System.out.println("Arrays.fill(h, 0, 2, 9);：");
        // 输出结果：993333666
        for (int i : h) {
            System.out.print(i);
        }
    }

    /**
     * @return void
     * @description: 数组转集合
     * @params:
     * @author: 01395265
     * @date: 2020/7/28
     */
    @Test
    public void test5() {
        /**
         * 数组转为集合，返回的ArrayList不是java.util.ArrayList，是Arrays的一个内部类 java.util.Arrays.ArrayList
         */
        List<String> stooges = Arrays.asList("Larry", "Moe", "Curly");

        /**
         * 将 java.util.Arrays.ArrayList 转为 java.util.ArrayList
         */
        ArrayList<String> strings = new ArrayList<>(stooges);

        System.out.println(stooges);
        System.out.println(strings);
    }

    /**
     * @return void
     * @description: 复制
     * @params:
     * @author: 01395265
     * @date: 2020/7/28
     */
    @Test
    public void test6() {
        // copyOf 方法实现数组复制，h为数组，6为复制的长度
        int[] h = {1, 2, 3, 3, 3, 3, 6, 6, 6, 9};
        int i[] = Arrays.copyOf(h, 6);  // [0, 6)
        System.out.println("Arrays.copyOf(h, 6);：");
        // 输出结果：123333
        for (int j : i) {
            System.out.print(j);
        }
        System.out.println();
        // copyOfRange将指定数组的指定范围复制到新数组中
        int j[] = Arrays.copyOfRange(h, 6, 11); // [6, 11)
        System.out.println("Arrays.copyOfRange(h, 6, 11)：");
        // 输出结果66600(h数组只有9个元素这里是从索引6到索引11复制所以不足的就为0)
        for (int j2 : j) {
            System.out.print(j2);
        }
    }

    /**
     * @return void
     * @description: deepEquals
     * @params:
     * @author: 01395265
     * @date: 2020/7/28
     */
    @Test
    public void test7() {

        String[][] name1 = {{"G", "a", "o"}, {"H", "u", "a", "n"}, {"j", "i", "e"}};
        String[][] name2 = {{"G", "a", "o"}, {"H", "u", "a", "n"}, {"j", "i", "e"}};

        /**
         * @description: 多维数组的情况下，需要使用deepEquals
         * @params:
         * @return void
         * @author: 01395265
         * @date: 2020/7/28
         */
        System.out.println(Arrays.equals(name1, name2));    // false
        System.out.println(Arrays.deepEquals(name1, name2));// true

        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.equals(arr1, arr2));
        System.out.println(Arrays.deepEquals(arr1, arr2));

        int [] chars1 = {'a', 'b', 'c'};
        int [] chars2 = {'a', 'b', 'c'};

        System.out.println(Arrays.equals(chars1, chars2));
        /**
         * @description: deepEquals 只有一个个重载方法：(Object[] a1, Object[] a2)。
         * @params:
         * @return void
         * @author: 01395265
         * @date: 2020/7/28
         */
//        System.out.println(Arrays.deepEquals(chars1, chars2));  // 编译错误

    }
}