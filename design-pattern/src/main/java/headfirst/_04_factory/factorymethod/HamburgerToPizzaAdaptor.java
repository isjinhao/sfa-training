package headfirst._04_factory.factorymethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/20
 */
public class HamburgerToPizzaAdaptor extends Pizza {

    Hamburger hamburger;

    public HamburgerToPizzaAdaptor(Hamburger hamburger, String name) {
        super(new HamburgerIngredientFactory());
        this.hamburger = hamburger;

        this.name = name;
    }

    public HamburgerToPizzaAdaptor() {
        super(new HamburgerIngredientFactory());
    }

    @Override
    protected void prepare() {

    }

    @Override
    void bake() {
        hamburger.bakeBread();
        hamburger.bakeMeat();
    }

    @Override
    void cut() {
        hamburger.assemble();
    }

    @Override
    void box() {
        hamburger.packing();
    }
}
