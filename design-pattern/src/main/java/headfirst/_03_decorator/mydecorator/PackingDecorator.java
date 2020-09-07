package headfirst._03_decorator.mydecorator;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public abstract class PackingDecorator extends Beverage {

    private Beverage beverage;

    public PackingDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    protected Beverage getBeverage() {
        return beverage;
    }

}
