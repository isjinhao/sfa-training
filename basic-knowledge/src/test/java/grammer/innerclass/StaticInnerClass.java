package grammer.innerclass;

import grammer.innerclass.Outer.Inner;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/4
 */
public class StaticInnerClass {

    public static void main(String[] args) {

        Inner inner = new Inner();

    }
}
class Outer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static class Inner {
        public static void test(){

            // 静态类不能使用
//            System.out.println(name);
        }
    }

}