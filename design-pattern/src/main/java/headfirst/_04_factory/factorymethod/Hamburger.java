package headfirst._04_factory.factorymethod;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/8/20
 */
public abstract class Hamburger {

    String bread;

    String meat;

    abstract void bakeBread();

    abstract void bakeMeat();

    void assemble() {
        System.out.println("将面包和肉组装在一起");
    }

    void packing(){
        System.out.println("将汉堡打包");
    }

    @Override
    public String toString() {
        return "Hamburger{" +
            "bread='" + bread + '\'' +
            ", meat='" + meat + '\'' +
            '}';
    }
}
