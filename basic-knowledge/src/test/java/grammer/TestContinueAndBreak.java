package grammer;

import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/7
 */
public class TestContinueAndBreak {


    /**
     * 跳出外层循环
     */
    @Test
    public void test1() {
        A:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == 5)
                    break A;
            }
            System.out.println(i);
        }
    }

    /**
     * 跳出内层循环，且输出 iiii : 5
     */
    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == 5)
                    break;
                System.out.println("j : " + j);
            }
            System.out.println("iiii : " + i);
        }
    }

    /**
     * 跳出内层循环，且输出 iiii : 5
     */
    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            A:
            for (int j = 0; j < 10; j++) {
                if(i == 5)
                    break A;
                System.out.println("j : " + j);
            }
            System.out.println("iiii : " + i);
        }
    }

    /**
     * 跳出内层循环，且输出 iiii : 5
     */
    @Test
    public void test4() {
        for (int i = 0; i < 10; i++) {
            A:
            for (int j = 0; j < 10; j++) {
                if(i == 5)
                    continue A;
                System.out.println("j : " + j);
            }
            System.out.println("iiii : " + i);
        }
    }

    /**
     * 跳出内层循环，不输出 iiii : 5
     */
    @Test
    public void test5() {
        A:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == 5)
                    continue A;
                System.out.println("j : " + j);
            }
            System.out.println("iiii : " + i);
        }
    }

    /**
     * 跳出内层循环，且输出 iiii : 5
     */
    @Test
    public void test6() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i == 5)
                    continue;
                System.out.println("j : " + j);
            }
            System.out.println("iiii : " + i);
        }
    }

}
