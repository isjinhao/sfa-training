package headfirst._03_decorator.mydecorator;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class Mocha extends Condiment {

    public Mocha() {
        super("mocha");
    }

    @Override
    public float cost() {
        return 1.1f;
    }
}
