package headfirst._03_decorator.starbuzz;

/**
 * Created by Gavin on 2017/3/7.
 */
public class Milk extends CondimentDecorator {



    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
