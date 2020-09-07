package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public class ChicagoPizzaStore extends PizzaStore {

    public ChicagoPizzaStore() {
        setPizzaIngredientFactory(new ChicagoIngredientFactory());
    }

    @Override
    Pizza createPizza(String item) {
        switch (item) {
            case "cheese":
                return new ChicagoStyleCheesePizza(pizzaIngredientFactory);
            case "veggie":
                return new ChicagoStyleVeggiePizza(pizzaIngredientFactory);
            default:
                return null;
        }
    }

}
