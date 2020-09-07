package headfirst._03_decorator.starbuzz;

/**
 * Created by Gavin on 2017/3/7.
 */
public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
