package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public class ChicagoStyleVeggiePizza extends Pizza {

    public ChicagoStyleVeggiePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        super(pizzaIngredientFactory);
        name = "Chicago Deep Dish Veggie Pizza";

        toppings.add("Shredded Mozzarella Cheese");
        toppings.add("Black Olives");
        toppings.add("Spinach");
        toppings.add("Eggplant");
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }

}
