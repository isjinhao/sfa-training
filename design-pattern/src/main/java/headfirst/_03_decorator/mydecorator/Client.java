package headfirst._03_decorator.mydecorator;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/18
 */
public class Client {

    public static void main(String[] args) {

        Beverage darkRoast = new DarkRoast();
        darkRoast.addCondiment(new Milk());
        darkRoast.addCondiment(new Mocha());

        System.out.println(darkRoast.getDescription() + " cost: " + darkRoast.cost() + ".");

        Beverage takeoutDecorator = new TakeoutDecorator(darkRoast);

        System.out.println(takeoutDecorator.getDescription() + " cost: " + takeoutDecorator.cost() + ".");

    }
}
