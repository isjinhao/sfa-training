package grammer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/13
 */
public class TestLambdaInCollection {

    /**
     * @return void
     * @description: forEach()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        /**
         * 接收 Consumer<T> 类型：void accept(T t);
         */
        list.forEach(str -> {
            if (str.length() > 3) {
                System.out.println(str);
            }
        });
    }


    /**
     * @return void
     * @description: removeIf()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test2() {
        /**
         * 接收 Predicate<T> 类型：boolean test(T t);
         */
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        list.removeIf(str -> str.length() > 3); // 删除长度大于3的元素
        System.out.println(list);
    }


    /**
     * @return void
     * @description: replaceAll()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test3() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        /**
         * 接收 UnaryOperator<T> extends Function<T, T> 类型：T apply(T t);
         */
        list.replaceAll(str -> {
            if (str.length() > 3) {
                return str.toUpperCase();
            }
            return str;
        });
        System.out.println(list);
    }


    @Test
    public void test4() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));
        /**
         * 接收 Comparator<T> 类型：int compare(T o1, T o2);
         */
        list.sort((str1, str2) -> str1.length() - str2.length());
        System.out.println(list);
    }

    /**
     * Map 中的新方法
     */

    /**
     * @return void
     * @description: forEach()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test5() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        /**
         * BiConsumer<T, U>：void accept(T t, U u);
         */
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }


    /**
     * @return void
     * @description: replaceAll()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test6() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        /**
         * BiFunction<T, U, R>：R apply(T t, U u);
         */
        map.replaceAll((k, v) -> v.toUpperCase());
        System.out.println(map);
    }


    /**
     * @return void
     * @description: merge()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test7() {
        /**
         * 1. 如果`Map`中`key`对应的映射不存在或者为`null`，则将`value`（不能是`null`）关联到`key`上；
         * 2. 否则执行`remappingFunction`，如果执行结果非`null`则用该结果跟`key`关联，否则在`Map`中删除`key`的映射．
         */
        Map<String, Integer> map = new HashMap<>();

        List<String> words = new ArrayList<>(Arrays.asList("a", "b", "c", "a", "b", "d"));

        words.forEach(word ->
            map.merge(word, 1, (prev, one) -> prev + one)
        );

        System.out.println(map);

    }


    /**
     * @return void
     * @description: computeIfAbsent()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test8() {
        /**
         * 该方法签名为`V computeIfAbsent(K key, Function<T, R> mappingFunction)`，作用是：只有在当前`Map`中不存在`key`值的映射或映射值为`null`时，
         * 才调用`mappingFunction`，并在`mappingFunction`执行结果非`null`时，将结果跟`key`关联。
         */
        String ret;
        Map<String, String> map = new HashMap<>();
        ret = map.computeIfAbsent("a", key -> key);
        System.out.println(ret);

        ret = map.computeIfAbsent("a", key -> key + "abc");
        System.out.println(ret);

        ret = map.computeIfAbsent("b", key -> null);
        System.out.println(map);

    }


    /**
     * @return void
     * @description: computeIfPresent()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test9() {
        /**
         * 该方法签名为`V computeIfPresent(K key, BiFunction remappingFunction)`，作用跟`computeIfAbsent()`相反，即，只有在当前`Map`中存在`key`值的映射且value非`null`时，
         * 才调用`remappingFunction`，如果`remappingFunction`执行结果为`null`，则删除`key`的映射，否则使用该结果替换`key`原来的映射．
         */
        String ret;
        Map<String, String> map = new HashMap<>();
        ret = map.computeIfPresent("a", (key, value) -> key + value); // ret null, map 为 {}
        System.out.println(ret);
        System.out.println(map);

        map.put("a", null); // map 为 ["a":null]
        ret = map.computeIfPresent("a", (key, value) -> key + value); // ret null, map为 {"a":null}
        System.out.println(ret);
        System.out.println(map);

        // ret "a+aaa", map 为 {"a":"a+aaa"}
        map.put("a", "+aaa");
        ret = map.computeIfPresent("a", (key, value) -> key + value);
        System.out.println(ret);
        System.out.println(map);

        // ret 为 null, map 为 {}，计算出的 null 把 key 删除了
        ret = map.computeIfPresent("a", (key, value) -> null);
        System.out.println(ret);
        System.out.println(map);

    }


    /**
     * @return void
     * @description: compute()
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test10() {
        /**
         * 该方法签名为`compute(K key, BiFunction remappingFunction)`，作用是把`remappingFunction`的计算结果关联到`key`上，如果计算结果为`null`，则在`Map`中删除`key`的映射．
         */
        String ret;
        Map<String, String> map = new HashMap<>();
        ret = map.compute("a", (key, value) -> "a" + value); // ret="anull", map={"a":"anull"}
        System.out.println(ret);
        System.out.println(map);


        ret = map.compute("a", (key, value) -> "a" + value); // ret="aanull", map={"a":"aanull"}
        System.out.println(ret);
        System.out.println(map);


        ret = map.compute("a", (key, value) -> null); // ret=null, map={}
        System.out.println(ret);
        System.out.println(map);
    }


}
