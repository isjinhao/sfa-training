package headfirst._03_decorator.starbuzz;

/**
 * Created by Gavin on 2017/3/7.
 */
public abstract class CondimentDecorator extends Beverage {

    Beverage beverage;

    @Override
    public abstract String getDescription();

}
