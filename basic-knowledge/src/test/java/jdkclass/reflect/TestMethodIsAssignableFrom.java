package jdkclass.reflect;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/2
 */
public class TestMethodIsAssignableFrom {

    public static void main(String[] args) {
        System.out.println(A92.class.isAssignableFrom(C92.class));
    }

}


interface A92{

}

interface B92 extends A92 {

}

abstract class C92 implements B92 {

}