package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public class NYPizzaStore extends PizzaStore {

    public NYPizzaStore() {
        setPizzaIngredientFactory(new NYPizzaIngredientFactory());
    }

    @Override
    Pizza createPizza(String item) {
        switch (item) {
            case "cheese":
                return new NYStyleCheesePizza(pizzaIngredientFactory);
            case "veggie":
                return new NYStyleVeggiePizza(pizzaIngredientFactory);
            case "whiteChickenHamburger":
                return new HamburgerToPizzaAdaptor(new WhiteChickenHamburger(), "whiteChickenHamburger");
            case "blackBeefHamburger":
                return new HamburgerToPizzaAdaptor(new BlackBeefHamburger(), "blackBeefHamburger");
            default:
                return null;
        }
    }

}
