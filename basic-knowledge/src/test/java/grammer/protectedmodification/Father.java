package grammer.protectedmodification;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class Father {

    protected int i;

    public static void main(String[] args) {

        Son son = new Son();

        System.out.println(son.i);

    }

}
