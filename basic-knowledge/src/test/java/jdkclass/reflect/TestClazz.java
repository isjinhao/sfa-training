package jdkclass.reflect;

import java.lang.reflect.Constructor;
import org.junit.Test;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/30
 */
public class TestClazz {

    public TestClazz(String msg) {
        System.out.println(msg);
    }

    public TestClazz() {
    }

    private TestClazz(int i) {
        System.out.println(i);
    }

    @Test
    public void test1() throws Exception {
        // 1、通过Object类的getClass()方法
        TestClazz tc = new TestClazz();
        Class clazz1 = tc.getClass();

        // 2、通过类的静态class属性。
        Class clazz2 = TestClazz.class;

        // 3、通过Class类中的方法构造。这种可拓展性更强，根本不需要知道类型，通过字符串就能获得。
        // 但是也正是这个原因，可能发生ClassNotFoundException（main函数的此异常与前两者无关）
        Class clazz3 = Class.forName("com.first.TestClazz");
    }



    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("jdkclass.reflect.TestClazz");

        Constructor[] constructors = clazz.getConstructors();
        for (Constructor e : constructors) {
            System.out.println(e);
        }
    }








}
