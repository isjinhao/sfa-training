package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public class PizzaTestDrive {
    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        Pizza whiteChickenHamburger = nyStore.orderPizza("whiteChickenHamburger");

    }
}
