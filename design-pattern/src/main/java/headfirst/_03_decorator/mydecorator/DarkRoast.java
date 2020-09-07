package headfirst._03_decorator.mydecorator;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return condimentCost() + 1;
    }

}