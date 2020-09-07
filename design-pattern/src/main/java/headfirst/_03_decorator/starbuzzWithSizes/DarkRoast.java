package headfirst._03_decorator.starbuzzWithSizes;

/**
 * Created by Gavin on 2017/3/8.
 */
public class DarkRoast extends Beverage {
    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
