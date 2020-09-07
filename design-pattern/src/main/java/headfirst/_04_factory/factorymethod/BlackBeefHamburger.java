package headfirst._04_factory.factorymethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/20
 */
public class BlackBeefHamburger extends Hamburger {

    @Override
    void bakeBread() {
        System.out.println("黑面包");
    }

    @Override
    void bakeMeat() {
        System.out.println("牛肉");
    }
}
