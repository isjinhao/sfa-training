package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public class NYStyleVeggiePizza extends Pizza {
    public NYStyleVeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
        name = "NY Style Veggie Pizza";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Garlic");
        toppings.add("Onion");
        toppings.add("Mushrooms");
        toppings.add("Red Pepper");
    }
}
