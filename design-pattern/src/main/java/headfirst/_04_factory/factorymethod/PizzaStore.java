package headfirst._04_factory.factorymethod;

/**
 * Created by Gavin on 2017/3/9.
 */
public abstract class PizzaStore {

    PizzaIngredientFactory pizzaIngredientFactory;

    protected void setPizzaIngredientFactory(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;

    }
}
