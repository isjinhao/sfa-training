package grammer.protectedmodification;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class Client {

    public static void main(String[] args) {

        Son son = new Son();

        /**
         * 相同的包下可以访问 protected 修饰的属性和方法
         */
        System.out.println(son.i);

    }

}
