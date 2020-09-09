package grammer.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/14
 */
public class TestStreamReduce {

    /**
     * reduce操作符是及早求值操作符，接受一个元素序列为输入，反复使用某个合并操作，把序列中的元素合并成一个汇总的结果，其生成的值不是随意的，而是根据指定的计算模型。reduce方法有三个override的方法。
     *  - Optional<T> reduce(BinaryOperator<T> accumulator);
     *  - T reduce(T identity, BinaryOperator<T> accumulator);
     *  - <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner);
     */

    /**
     * @return void
     * @description: Optional<T> reduce(BinaryOperator<T> accumulator);
     * @params:
     * @author: 01395265
     * @date: 2020/8/14
     */
    @Test
    public void test1() {

        /**
         * Performs a reduction on the elements of this stream, using an associative accumulation function, and returns
         * an Optional describing the reduced value, if any. This is equivalent to:
         *  boolean foundAny = false;
         *  T result = null;
         *  for (T element : this stream) {
         *      if (!foundAny) {
         *          foundAny = true;
         *          result = element;
         *      }
         *      else
         *          result = accumulator.apply(result, element);
         *  }
         *  return foundAny ? Optional.of(result) : Optional.empty();
         * but is not constrained to execute sequentially. The accumulator function must be an associative function. This is a terminal operation.
         */
        Stream.of(1, 2, 3).reduce((sum, item) -> {
            System.out.println(sum);
            return sum - item;
        }).ifPresent(System.out::println);

    }


    /**
     * @return void
     * @description: T reduce(T identity, BinaryOperator<T> accumulator);
     * @params:
     * @author: 01395265
     * @date: 2020/8/14
     */
    @Test
    public void test2() {

        /**
         * Performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function,
         * and returns the reduced value. This is equivalent to:
         *  T result = identity;
         *  for (T element : this stream)
         *      result = accumulator.apply(result, element)
         *  return result;
         * but is not constrained to execute sequentially. The identity value must be an identity for the accumulator function.
         * This means that for all t, accumulator.apply(identity, t) is equal to t. The accumulator function must be an associative function. This is a terminal operation.
         */
        Integer reduce = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(1, (sum, item) -> {
            System.out.println(sum);
            return sum - item;
        });
        System.out.println(reduce);

    }


    @Test
    public void test3() {

        /**
         * Reduce 完成集合汇聚。
         */
        List<String> list1 = Arrays.asList("1", "2");
        List<String> list2 = Arrays.asList("3", "4");
        List<String> list3 = Arrays.asList("5", "6");
        List<String> list4 = Arrays.asList("7", "8");
        List<String> list5 = Arrays.asList("9", "10");

        List<String> list = Stream.of(list1, list2, list3, list4, list5).reduce(new ArrayList<>(), (sum, item) -> {
            sum.addAll(item);
            return sum;
        });

        list.forEach(System.out::println);

    }

}
