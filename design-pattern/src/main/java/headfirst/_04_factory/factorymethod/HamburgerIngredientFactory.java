package headfirst._04_factory.factorymethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/20
 */
public class HamburgerIngredientFactory implements PizzaIngredientFactory {

    @Override
    public String getDough() {
        return "";
    }

    @Override
    public String getSauce() {
        return "";
    }
}
