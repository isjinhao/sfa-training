package headfirst._03_decorator.starbuzzWithSizes;

/**
 * Created by Gavin on 2017/3/8.
 */
public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;
    @Override
    public abstract String getDescription();

    @Override
    public Size getSize() {
        return beverage.getSize();
    }
}
