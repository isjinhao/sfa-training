package headfirst._04_factory.factorymethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/19
 */
public class ChicagoIngredientFactory implements PizzaIngredientFactory{

    @Override
    public String getDough() {
        return "Chicago Dough";
    }

    @Override
    public String getSauce() {
        return "Chicago Sauce";
    }
}
