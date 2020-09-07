package jdkclass.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/5
 */
public class TestJdk8Before {

    /**
     * @description: java.util.Date 有一个最大的好处就是可以接受从 epoch time 至今的毫秒数作为参数，在前后端传输数据时很好用
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/5
     */
    @Test
    public void test1() {

        /**
         * 等价于 new Date(System.currentTimeMillis());
         */
        System.out.println(new Date());

        System.out.println(new Date(System.currentTimeMillis()));

    }

    /**
     * @description: System 类关于时间的方法
     * @params:
     * @return void
     * @author: 01395265
     * @date: 2020/8/5
     */
    @Test
    public void test2() throws InterruptedException {

        /**
         * 毫秒
         */
        System.out.println(System.currentTimeMillis());

        /**
         * 纳秒。返回的数值不是 epoch time 至今的时间。返回的数值具有不确定性，甚至可能是负数，所以仅能用于计算 elapsed time。
         */
        System.out.println(System.nanoTime());

        long start = System.nanoTime();
        TimeUnit.SECONDS.sleep(1);
        long end = System.nanoTime();

        System.out.println(end - start);

    }


    @Test
    public void test3() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

        String format = simpleDateFormat.format(new Date());

        System.out.println(format);

        Date parse = simpleDateFormat.parse(format);

        System.out.println(parse);

    }



}
