package headfirst._04_factory.factorymethod;

import java.util.ArrayList;

/**
 * Created by Gavin on 2017/3/9.
 */
public abstract class Pizza {

    PizzaIngredientFactory pizzaIngredientFactory;

    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public Pizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.pizzaIngredientFactory = pizzaIngredientFactory;
    }

    protected void prepare() {
        System.out.println("Prepare " + name);
        System.out.println(pizzaIngredientFactory.getDough());
        System.out.println(pizzaIngredientFactory.getSauce());
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.print("   " + topping);
        }
        System.out.println();
    }

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }

}
