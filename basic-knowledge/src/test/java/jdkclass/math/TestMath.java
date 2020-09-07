package jdkclass.math;

import java.util.Random;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class TestMath {

    @Test
    public void test1() {

        Random random = new Random();
        /**
         * 返回 (0, n] 之间的随机整数
         */
        int i = random.nextInt(10);
        System.out.println(i);

        /**
         * 实际上也是委托给 Random 做的
         */
        double iRandom = Math.random();
        System.out.println(iRandom);

    }

    @Test
    public void test2() {

        /**
         * 负数：加0.5之后向小的取整
         */
        System.out.println(Math.round(-11.6));
        System.out.println(Math.round(-11.5));

        /**
         * 正数：加0.5之后向大的取整
         */
        System.out.println(Math.round(11.6));
        System.out.println(Math.round(11.5));

    }

}
