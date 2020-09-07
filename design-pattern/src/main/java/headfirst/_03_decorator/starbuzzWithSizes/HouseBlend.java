package headfirst._03_decorator.starbuzzWithSizes;

/**
 * Created by Gavin on 2017/3/8.
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
