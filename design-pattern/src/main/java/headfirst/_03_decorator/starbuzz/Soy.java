package headfirst._03_decorator.starbuzz;

/**
 * Created by Gavin on 2017/3/7.
 */
public class Soy extends CondimentDecorator {

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }
}
