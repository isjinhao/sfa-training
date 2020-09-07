package headfirst._04_factory.factorymethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/19
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public String getDough() {
        return "New York Dough";
    }

    @Override
    public String getSauce() {
        return "New York Sauce";
    }

}