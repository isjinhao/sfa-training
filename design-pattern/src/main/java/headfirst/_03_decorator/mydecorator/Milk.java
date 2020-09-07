package headfirst._03_decorator.mydecorator;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class Milk extends Condiment {

    public Milk() {
        super("milk");
    }

    @Override
    public float cost() {
        return 1.2f;
    }
}
