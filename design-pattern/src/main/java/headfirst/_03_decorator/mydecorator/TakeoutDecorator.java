package headfirst._03_decorator.mydecorator;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class TakeoutDecorator extends PackingDecorator {

    public TakeoutDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return "take out food. " + getBeverage().getDescription();
    }

    @Override
    public double cost() {
        return 1 + getBeverage().cost();
    }

}
