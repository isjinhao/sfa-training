package grammer.stream;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author 01395265
 * @description 初识流
 * @date 2020/8/13
 */
public class TestStreamFirstAcquaintance {

    /**
     * 在最开始接触到这个名词的时候，我们应该都是有一个问题，此流和IO流有什么关系？实际上它俩一点关系都没有，IO流描述的是对IO的操作如同流水线操作一样，
     * 比如我们读一个字节处理一个字节或者读一行处理一行。而Stream这个流也是这个意思，它将对数据源的处理也描述的向流水线操作一样。
     * 一个Stream包含一个源、0个或多个中间操作和一个终止操作。由于Stream遵循惰性求值的规范，所以中间操作不会产生任何结果，只有遇到终止操作才会产生结果。
     */

    /**
     * @return void
     * @description: 通过可变参、数组、集合构建源
     * @params:
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test1() {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
        Stream<String> stream1 = Arrays.stream(new String[]{"hello", "world", "hello world"});
        Stream<String> stream2 = Arrays.asList("hello", "world", "hello world").stream();
    }

    /**
     * @description: IntStream
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test2() {
        /**
         * IntStream LongStream Stream DoubleStream 都是 BaseStream 的子接口
         */
        IntStream intStream = IntStream.of(new int[]{5, 6, 7});
        intStream.forEach(System.out::println);
        System.out.println("-------------------");
        // 输出 [3,8) 返回的数据
        IntStream.range(3, 8).forEach(System.out::println);

        System.out.println("-------------------");
        // 输出 [3,8] 返回的数据
        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }


    /**
     * @description: 中间过程和中止操作
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        System.out.println(list.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 2;
            }
        }).reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }));

        // map是中间过程，reduce是终止操作
        System.out.println(list.stream().map(i -> i * 2).reduce(1, Integer::sum));
    }


    /**
     * @description: 流的中止
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test4() {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

        // Returns an array containing the elements of this stream,
        // using the provided generator function to allocate the returned array,
        // as well as any additional arrays that might be required for a partitioned
        // execution or for resizing. This is a terminal operation.
        String[] strings = stream.toArray(length -> new String[length]);
        System.out.println(Arrays.deepToString(strings));

    //    相同的效果，但是不能在这里和上面的的代码同时出现，因为toArray是一个终止操作，stream已经终止了
    //	  这里就像一个IO流被关闭了就不能再使用一样
    //    List<String> collect = stream.collect(Collectors.toList());
    //    System.out.println(collect);
    }


    /**
     * @description: 生成序列
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/13
     */
    @Test
    public void test5() {
        // Returns an infinite sequential unordered stream where each element is generated
        // by the provided Supplier. This is suitable for generating constant streams,
        // streams of random elements, etc.
        Stream<String> generate = Stream.generate(UUID.randomUUID()::toString);
        Stream<String> limit = generate.limit(3);
        List<String> collect = limit.collect(Collectors.toList());
        System.out.println(collect);

        // Returns an infinite sequential ordered Stream produced by iterative application of a
        // function f to an initial element seed, producing a Stream consisting of seed, f(seed),
        // f(f(seed)), etc. The first element (position 0) in the Stream will be the provided seed.
        // For n > 0, the element at position n, will be the result of applying the function f to
        // the element at position n - 1.
        Stream<Integer> iterate = Stream.iterate(5, (item) -> item + item);

        Stream<Integer> limit1 = iterate.limit(10);
        List<Integer> collect1 = limit1.collect(Collectors.toList());
        System.out.println(collect1);

    }




}