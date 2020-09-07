package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
        name = "NY Style Sauce and Cheese Pizza";

        toppings.add("Grated Reggiano Cheese");
    }
}
