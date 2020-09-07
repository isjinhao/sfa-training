package jdkclass.math;

import java.math.BigDecimal;
import java.math.MathContext;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class TestBigDecimal {

    @Test
    public void test1() {

        BigDecimal bigDecimal1 = new BigDecimal("1234.56789");

        /**
         * 四舍五入
         */
        System.out.println(bigDecimal1.round(new MathContext(5)));

        /**
         * 计算 and 四舍五入
         */
        BigDecimal bigDecimal2 = new BigDecimal("1234.56789");
        BigDecimal add = bigDecimal1.add(bigDecimal2, new MathContext(5));
        System.out.println(add);

    }

    @Test
    public void test2() {

        BigDecimal bigDecimal1 = new BigDecimal(1.01);
        BigDecimal bigDecimal2 = new BigDecimal(1.02);
        BigDecimal bigDecimal3 = new BigDecimal("1.01");
        BigDecimal bigDecimal4 = new BigDecimal("1.02");

        /**
         * 必须使用 String 构造对象
         */
        System.out.println(bigDecimal1.add(bigDecimal2));
        System.out.println(bigDecimal3.add(bigDecimal4));

    }


}
