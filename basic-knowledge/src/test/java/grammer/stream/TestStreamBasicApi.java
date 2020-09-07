package grammer.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author 01395265
 * @description 流相关的简单API
 * @date 2020/8/13
 */
public class TestStreamBasicApi {

    /**
     * @return void
     * @description: forEach()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test1() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
//        stream.forEach(str -> System.out.println(str));
        stream.forEach(System.out::println);
    }


    /**
     * @description: filter()
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test2() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.filter(str -> str.length() == 3).forEach(System.out::println);
    }


    /**
     * @description: distinct()
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test3() {
        Stream<String> stream= Stream.of("I", "love", "you", "too", "too");
        stream.distinct().forEach(str -> System.out.println(str));
    }


    /**
     * @description: sorted()
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test4() {
        Stream<String> stream= Stream.of("I", "love", "you", "too");
//        stream.sorted((str1, str2) -> str1.length()-str2.length()).forEach(System.out::println);
        stream.sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
//        stream.sorted(Comparator.comparingInt(new ToIntFunction<String>() {
//            @Override
//            public int applyAsInt(String value) {
//                return value.length();
//            }
//        })).forEach(System.out::println);
    }

    /**
     * @description: map()
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test5() {
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.map(str -> str.toUpperCase()).forEach(str -> System.out.println(str));
    }

    @Test
    public void test6() {
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        Stream<Integer> integerStream = stream.flatMap(list -> list.stream());

        stream.flatMap(list -> list.stream()).forEach(i -> System.out.println(i));
    }


    @Test
    public void test7() {
        // peek操作一般用于不想改变流中元素本身的类型或者只想操作元素的内部状态时；而map则用于改变流中元素本身
        // 类型，即从元素中派生出另一种类型的操作。这是他们之间的最大区别。
        String[] arr = new String[]{"a","b","c","d"};
        Arrays.stream(arr)
            .peek(System.out::println) // a,b,c,d
            .count();
    }


    @Test
    public void test8() {
        /**
         * - `allMatch`只有在所有的元素都满足断言时才返回true，否则false，流为空时总是返回true
         * - `anyMatch`只有在任意一个元素满足断言时就返回true，否则false
         * - `noneMatch`只有在所有的元素都不满足断言时才返回true，否则false
         */
        System.out.println(Stream.of(1,2,3,4,5).allMatch( i -> i > 0)); // true
        System.out.println(Stream.of(1,2,3,4,5).anyMatch( i -> i > 0)); // true
        System.out.println(Stream.of(1,2,3,4,5).noneMatch( i -> i > 0)); // false
        System.out.println(Stream.<Integer>empty().allMatch( i -> i > 0)); // true
        System.out.println(Stream.<Integer>empty().anyMatch( i -> i > 0)); // false
        System.out.println(Stream.<Integer>empty().noneMatch( i -> i > 0)); // true
    }


}
